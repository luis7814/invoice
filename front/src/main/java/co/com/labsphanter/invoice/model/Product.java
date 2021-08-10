package co.com.labsphanter.invoice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
    private String name;
    private String description;
    private String type;
    private Integer price;
    private String image;
    private String message;

}
