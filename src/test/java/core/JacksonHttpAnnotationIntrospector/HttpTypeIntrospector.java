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

        if(type != null && type.value() != HttpType.Direction.BOTH && type.value() != direction){
            return true;
        }
        return super.hasIgnoreMarker(m);
    }

    @Override
    public Boolean hasRequiredMarker(AnnotatedMember m) {
        RequiredFor vals = m.getAnnotation(RequiredFor.class);

        if(vals != null){
            for(HttpType.Direction d : vals.value()){
                if(d == HttpType.Direction.BOTH || d == direction){
                    return true;
                }
            }
        }
        return super.hasRequiredMarker(m);

    }
}
