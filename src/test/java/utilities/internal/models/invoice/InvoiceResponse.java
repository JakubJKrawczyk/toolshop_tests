package utilities.internal.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceResponse extends InvoiceRequest{

    @JsonProperty("invoice_date")
    public String invoiceDate;

    @JsonProperty("invoice_number")
    public String invoiceNumber;

    public String status;

    @JsonProperty("status_message")
    public String statusMessage;


}
