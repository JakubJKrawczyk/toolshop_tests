package utilities.internal.models.category;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoryTreeResponse extends ModelBase {

    @JsonProperty("sub_categories") public List<CategoryResponse> subCategories;
}
