package co.com.labsphanter.invoice.controller;

import co.com.labsphanter.invoice.object.model.ProductType;
import co.com.labsphanter.invoice.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/productType")
    public ResponseEntity<List<ProductType>> findAll() {
        try {
            return new ResponseEntity<>(productTypeService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productType/{id}")
    public ResponseEntity<List<ProductType>> findById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(productTypeService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productType")
    public ResponseEntity<ProductType> save(@RequestBody ProductType productType) {
        try {
            return new ResponseEntity<>(productTypeService.save(productType), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ProductType(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/productType")
    public ResponseEntity<ProductType> update(@RequestBody ProductType productType) {
        try {
            return new ResponseEntity<>(productTypeService.update(productType), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ProductType(), HttpStatus.NOT_FOUND);
        }
    }
}
