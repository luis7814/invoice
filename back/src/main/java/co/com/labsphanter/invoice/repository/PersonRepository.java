package co.com.labsphanter.invoice.repository;

import co.com.labsphanter.invoice.object.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByLoginAndPassword(String login, String password);
}
