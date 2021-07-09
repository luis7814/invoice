package co.com.labsphanter.invoice.controller;

import co.com.labsphanter.invoice.object.model.Person;
import co.com.labsphanter.invoice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll() {
        try {
            return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Person(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/{authentication}/{id}")
    public ResponseEntity<Person> findByLoginAndPassword(@PathVariable String authentication, @PathVariable String id) {

        Person person = personService.findByLoginAndPassword(authentication);

        if(!person.getLogin().isEmpty()) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(person, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        try {
            return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Person(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/person")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        try {
            return new ResponseEntity<>(personService.update(person), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new Person(), HttpStatus.NOT_FOUND);
        }
    }
    
}
