package utilities.internal.models.image;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponse {

    @JsonProperty("by_name")
    public String byName;

    @JsonProperty("by_url")
    public String byUrl;

    @JsonProperty("source_name")
    public String sourceName;

    @JsonProperty("source_url")
    public String sourceUrl;

    @JsonProperty("file_name")
    public String fileName;

    public String title;

    @JsonProperty("created_at")
    public String createdAt;

    public Integer id;
}
