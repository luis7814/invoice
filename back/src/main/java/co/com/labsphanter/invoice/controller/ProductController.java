package co.com.labsphanter.invoice.controller;

import co.com.labsphanter.invoice.object.model.Product;
import co.com.labsphanter.invoice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAll() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Product>> findById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Product(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Product(), HttpStatus.NOT_FOUND);
        }
    }
    
}
