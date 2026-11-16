package utilities.internal.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactReply extends ModelBase {

    public String message;

    @JsonProperty("created_at") public String createdAt;
}
