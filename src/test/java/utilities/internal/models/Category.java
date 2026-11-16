package utilities.internal.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category extends ModelBase{

    public String name;
    public String slug;
    @JsonProperty("parent_id") public String parentId;



}
