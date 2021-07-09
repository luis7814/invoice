package co.com.labsphanter.invoice.object.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "producttype")
public class ProductType implements Serializable {

    @Id
    private String id;
    private String name;

    @Transient
    private String message;
}
