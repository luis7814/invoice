package co.com.labsphanter.invoice.service;

import co.com.labsphanter.invoice.object.model.Person;
import co.com.labsphanter.invoice.repository.PersonRepository;
import co.com.labsphanter.invoice.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private String login;
    private String password;

    public Person save(Person person) {

        person.setId(Utilities.generationId());

        personRepository.save(person);
        return person;
    }

    public Person update(Person person) {
        personRepository.save(person);
        return person;
    }

    public Person findById(String id) {
        return Optional.ofNullable(
                personRepository.findById(id))
                .get()
                .orElse(new Person());
    }

    public Person findByLoginAndPassword(String authentication) {

        authentication = Utilities.decodedBase64(authentication);

        login = authentication.split(";")[0];
        password = authentication.split(";")[1];

        return Optional.ofNullable(
                personRepository.findByLoginAndPassword(login, password))
                .map(value -> {
                    if(value.getLogin().equals(login)
                            && value.getPassword().equals(password)) {
                        value.setPassword("");
                        return value;
                    }else {
                        return new Person();
                    }
                })
                .get();

    }
    
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
