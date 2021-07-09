package co.com.labsphanter.invoice.repository;

import co.com.labsphanter.invoice.object.model.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TableRepository extends MongoRepository<Table, String> {
}
