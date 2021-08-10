package co.com.labsphanter.invoice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String initDate;
    private String endDate;
    private String login;
    private String password;
	

}
