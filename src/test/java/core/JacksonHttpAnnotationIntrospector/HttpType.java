package core.JacksonHttpAnnotationIntrospector;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.RECORD_COMPONENT})
public @interface HttpType{
    Direction value() default Direction.BOTH;
    enum Direction {REQUEST, RESPONSE, BOTH}
}