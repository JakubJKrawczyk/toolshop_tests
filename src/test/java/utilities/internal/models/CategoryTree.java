package utilities.internal.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoryTree extends Category{

    @JsonProperty("sub_categories") public List<Category> subCategories;
}
