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


//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    public Mono<Person> addOne(Person person) {
        return personRepo.save(person);
    }

    public Mono<Void> delete(Person person) {
        return personRepo.delete(person);
    }
}
