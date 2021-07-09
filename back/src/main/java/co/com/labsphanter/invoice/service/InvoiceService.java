package co.com.labsphanter.invoice.service;

import co.com.labsphanter.invoice.object.model.Invoice;
import co.com.labsphanter.invoice.repository.InvoiceRepository;
import co.com.labsphanter.invoice.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice save(Invoice invoice) {
        invoice.setId(Utilities.generationId());
        invoiceRepository.save(invoice);
        return invoice;
    }

    public Invoice update(Invoice invoice) {
        invoiceRepository.save(invoice);
        return invoice;
    }

    public Invoice findById(String id) {
        return Optional.ofNullable(
                invoiceRepository.findById(id))
                .get()
                .orElse(new Invoice());
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }
}
