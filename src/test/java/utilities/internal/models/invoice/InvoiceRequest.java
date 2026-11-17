package utilities.internal.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceRequest {

    @JsonProperty("user_id")
    public Integer userId;

    @JsonProperty("billing_address")
    public String billingAddress;

    @JsonProperty("billing_city")
    public String billingCity;

    @JsonProperty("billing_country")
    public String billingCountry;

    @JsonProperty("billing_state")
    public String billingState;

    @JsonProperty("billing_postcode")
    public String billingPostcode;

    public Number total;

    @JsonProperty("payment_method")
    public String paymentMethod;

    @JsonProperty("payment_account_name")
    public String paymentAccountName;

    @JsonProperty("payment_account_number")
    public String paymentAccountNumber;

    @JsonProperty("invoice_items")
    public InvoiceItem[] invoiceItems;

}
