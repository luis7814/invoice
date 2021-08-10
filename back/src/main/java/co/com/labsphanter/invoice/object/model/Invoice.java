package co.com.labsphanter.invoice.object.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "invoice")
public class Invoice implements Serializable {

    @Id
    private String id;
    private String date;
    private String table;
    private String total;
    private String state;
    private String person;
    private List<InvoiceDetail> invoiceDetails;

    @Transient
    private String message;

    @Data
    public static class InvoiceDetail {

        private String product;
        private Integer price;
        private Integer amount;
        private Integer total;
        private String description;

    }

}
