package co.com.labsphanter.invoice.repository;

import co.com.labsphanter.invoice.object.model.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductTypeRepository extends MongoRepository<ProductType, String> {

    ProductType findByName(String name);
}
