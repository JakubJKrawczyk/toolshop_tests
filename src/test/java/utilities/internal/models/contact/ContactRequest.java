package utilities.internal.models.contact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactRequest extends ContactBase{
    public String email;

    @JsonProperty(required = true)
    public String subject;

    @JsonProperty(required = true)
    public String message;
}
