package evolution.tracker.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Flux<Person> getAll() {
        return personRepo.findAll();
    }

    public Mono<Person> getById(Long id) {
        return personRepo.findById(id);
    }

    public Mono<Person> getBy(String email) {
        return personRepo.findByEmail(email);
    }

    public Flux<Person> getBy(String firstName, String lastName) {
        return personRepo.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Mono<Person> update(Person person) {
        if (person.getId() == null) {
            throw new IllegalArgumentException("Updated entity must to contain id");
        }
        return personRepo.save(person);
    }

    public Mono<Person> addOne(Person person) {
        if (person.getId() != null) {
            throw new IllegalArgumentException("New entity shouldn't contain id");
        }
        return personRepo.save(person);
    }

    public Mono<Void> delete(Long id) {
        return personRepo.deleteById(id);
    }
}
