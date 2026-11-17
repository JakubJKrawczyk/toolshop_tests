package utilities.internal.models.contact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactResponseAuthenticated extends ContactBase{
    @JsonProperty("user_id")
    public Integer userId;

    public String email;
    public String status;
    @JsonProperty("created_at")
    public String createdAt;
}
