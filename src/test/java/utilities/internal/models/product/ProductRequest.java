package utilities.internal.models.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequest {

    public String name;

    public String description;

    public Number price;

    @JsonProperty("category_id")
    public Integer categoryId;

    @JsonProperty("brand_id")
    public Integer brandId;

    @JsonProperty("product_image_id")
    public Integer productImageId;

    @JsonProperty("is_location_offer")
    public Integer isLocationOffer;

    @JsonProperty("is_rental")
    public Integer isRental;

    @JsonProperty("co2_rating")
    public Co2Rating co2Rating;

    public enum Co2Rating{
        A,
        B,
        C,
        D,
        E
    }

}
