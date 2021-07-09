package co.com.labsphanter.invoice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
    private String date;
    private String table;
    private String total;
    private String message;

    @Data
    public static class InvoiceDetail {

        private String product;
        private Integer price;
        private Integer amount;
        private Integer total;

    }

}
