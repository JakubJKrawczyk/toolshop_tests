package core.JacksonHttpAnnotationIntrospector;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.RECORD_COMPONENT})
public @interface HttpType{
    Direction value();
    enum Direction {REQUEST, RESPONSE}
}