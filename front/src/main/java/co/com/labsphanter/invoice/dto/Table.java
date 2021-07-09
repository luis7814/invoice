package co.com.labsphanter.invoice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;
	
    private String id;
    private String number;
    private String status;
    private String flat;
    private String message;
    
}
