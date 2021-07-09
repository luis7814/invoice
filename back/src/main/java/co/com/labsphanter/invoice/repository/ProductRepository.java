package co.com.labsphanter.invoice.repository;

import co.com.labsphanter.invoice.object.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);

}
