package co.com.labsphanter.invoice.controller;

import co.com.labsphanter.invoice.object.model.Invoice;
import co.com.labsphanter.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> findAll() {
        try {
            return new ResponseEntity<>(invoiceService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> save(@RequestBody Invoice invoice) {
        try {
            return new ResponseEntity<>(invoiceService.save(invoice), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Invoice(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/invoice")
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice) {
        try {
            return new ResponseEntity<>(invoiceService.update(invoice), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Invoice(), HttpStatus.NOT_FOUND);
        }
    }

}
