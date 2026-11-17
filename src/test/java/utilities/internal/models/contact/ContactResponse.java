package utilities.internal.models.contact;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.JacksonHttpAnnotationIntrospector.HttpType;
import core.JacksonHttpAnnotationIntrospector.RequiredFor;

public class ContactResponse extends ContactBase{

    public String email;
    public String status;
    public String createdAt;
}
