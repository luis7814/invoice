package co.com.labsphanter.invoice.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Invoice implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    private String id;
    private String date;
    private String table;
    private String total;
    private String state;
    private String person;
    private String message;
    private List<InvoiceDetail> invoiceDetails;

    @Data
    public static class InvoiceDetail {

        private String product;
        private Integer price;
        private Integer amount;
        private Integer total;
        private String description;

    }

}
