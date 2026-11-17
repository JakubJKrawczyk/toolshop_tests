package utilities.internal.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceLineResponse {

    public Integer id;

    @JsonProperty("unit_price")
    public Number unitPrice;

    public Integer quantity;

    public ProductResponse product;
}
