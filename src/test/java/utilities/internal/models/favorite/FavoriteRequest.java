package utilities.internal.models.favorite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FavoriteRequest {
    @JsonProperty("product_id")
    public Integer productId;
}
