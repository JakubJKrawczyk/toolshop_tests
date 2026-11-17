package utilities.internal.models.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import utilities.internal.models.brand.BrandResponse;
import utilities.internal.models.category.CategoryResponse;
import utilities.internal.models.image.ImageResponse;

public class ProductResponse extends ProductRequest{

    public Integer id;

    @JsonProperty("is_eco_friendly")
    public boolean isEcoFriendly;

    public BrandResponse brand;

    public CategoryResponse category;

    @JsonProperty("product_image")
    public ImageResponse productImage;

}


