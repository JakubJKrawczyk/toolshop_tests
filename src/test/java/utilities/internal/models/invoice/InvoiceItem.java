package utilities.internal.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceItem {

    @JsonProperty("product_id")
    public Integer productId;

    public Integer quantity;

    @JsonProperty("unit_price")
    public Number unitPrice;

}
