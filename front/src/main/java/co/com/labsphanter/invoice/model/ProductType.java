package co.com.labsphanter.invoice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String name;
    private String message;

}
