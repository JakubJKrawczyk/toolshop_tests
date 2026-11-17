package utilities.internal.models.contact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactReplyResponse  {
    public Integer id;
    public String message;

    @JsonProperty("created_at") public String createdAt;
}
