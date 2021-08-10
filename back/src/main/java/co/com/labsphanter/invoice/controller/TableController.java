package co.com.labsphanter.invoice.controller;

import co.com.labsphanter.invoice.object.model.Table;
import co.com.labsphanter.invoice.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/table")
    public ResponseEntity<List<Table>> findAll() {
        try {
            return new ResponseEntity<>(tableService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/table/{id}")
    public ResponseEntity<List<Table>> findById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(tableService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/table")
    public ResponseEntity<Table> save(@RequestBody Table table) {
        try {
            return new ResponseEntity<>(tableService.save(table), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Table(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/table")
    public ResponseEntity<Table> update(@RequestBody Table table) {
        try {
            return new ResponseEntity<>(tableService.update(table), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Table(), HttpStatus.NOT_FOUND);
        }
    }
}
