package utilities.internal.models;

import core.JacksonHttpAnnotationIntrospector.HttpType;

public class ModelBase {
    @HttpType(HttpType.Direction.RESPONSE)
    public String id;
}
