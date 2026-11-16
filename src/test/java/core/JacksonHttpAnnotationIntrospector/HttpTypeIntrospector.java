package core.JacksonHttpAnnotationIntrospector;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public final class HttpTypeIntrospector extends  JacksonAnnotationIntrospector{

    private final HttpType.Direction direction;

    public HttpTypeIntrospector(HttpType.Direction direction){
        this.direction = direction;
    }

    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m) {
        HttpType type = m.getAnnotation(HttpType.class);

        if(type != null && type.value() != direction){
            return true;
        }
        return super.hasIgnoreMarker(m);
    }
}
