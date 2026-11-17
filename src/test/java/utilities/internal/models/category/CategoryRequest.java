package utilities.internal.models.category;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest extends ModelBase {

    public String name;
    public String slug;
    @JsonProperty("parent_id") public String parentId;
}
