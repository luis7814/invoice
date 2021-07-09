package co.com.labsphanter.invoice.repository;

import co.com.labsphanter.invoice.object.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {

}
