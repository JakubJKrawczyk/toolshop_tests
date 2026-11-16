package utilities;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.JacksonHttpAnnotationIntrospector.HttpType;
import core.JacksonHttpAnnotationIntrospector.HttpTypeIntrospector;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

public final class ClientApi {
    public String baseApiUrl;
    public ObjectMapper requestMapper;
    public ObjectMapper responseMapper;
    public HttpClient client;



    public ClientApi(String baseUrl){
        ObjectMapper base = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .findAndRegisterModules();

        this.responseMapper = base.copy()
                .setAnnotationIntrospector(new HttpTypeIntrospector(HttpType.Direction.RESPONSE));

        this.requestMapper = base.copy()
                .setAnnotationIntrospector(new HttpTypeIntrospector(HttpType.Direction.REQUEST));

        this.baseApiUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl+"/";
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    public <T> HttpResponse<T> execute(HttpRequest request, HttpResponse.BodyHandler<T> handler){
        try{
            return client.send( request, handler);
        }catch (IOException e){
            throw new IllegalStateException("HTTP Failed" + request.uri(), e);
        }catch (InterruptedException e){
            throw new IllegalStateException("HTTP Failed: " + request.uri(), e);
        }
    }

    public HttpResponse<String> get(String path, Map<String, String> query){
        return execute(
                newBuilder(path, query).GET().build(),
                HttpResponse.BodyHandlers.ofString()
        );

    }

    public HttpResponse<String> get(String path){
        return get(path, Map.of());
    }

    public HttpResponse<String> post(String path, Object body){
        var builder = newBuilder(path, Map.of());
        HttpRequest.BodyPublisher publisher;

        if(body == null){
            publisher = HttpRequest.BodyPublishers.noBody();
        }else{
            publisher = HttpRequest.BodyPublishers.ofString(toJson(body));
            builder.header("Content-Type", "application/json");
        }

        return execute(
                builder.POST(publisher).build(),
                HttpResponse.BodyHandlers.ofString()
        );
    }




    private HttpRequest.Builder newBuilder(String path, Map<String, String> query) {
        URI uri = URI.create(this.baseApiUrl
                + path.replaceAll("^/+", "")
                + queryString(query));
        return HttpRequest.newBuilder(uri)
                .header("Accept", "application/json")
                .timeout(Duration.ofSeconds(15));
    }


    // HELPERS
    private String queryString(Map<String, String> query) {
        if (query.isEmpty()) return "";
        return "?" + query.entrySet().stream()
                .map(e -> enc(e.getKey()) + "=" + enc(e.getValue()))
                .collect(Collectors.joining("&"));
    }

    private static String enc(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    private String toJson(Object body) {
        if (body instanceof String json) return json;   // pozwala podać surowy JSON
        try {
            return requestMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot serialize body", e);
        }
    }

    public <T> T deserialize(String json, Class<T> type){
        try{
            return responseMapper.readValue(json, type);
        }catch (JsonProcessingException e){
            throw new IllegalArgumentException(
                    "cannot deserialize" + type.getSimpleName(), e
            );
        }
    }
}
