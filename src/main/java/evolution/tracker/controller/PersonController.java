package evolution.tracker.controller;

import evolution.tracker.dao.person.Person;
import evolution.tracker.dao.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @GetMapping("all")
    public Flux<Person> list() {
        return personService.getAll();
    }

    @PostMapping
    public Mono<Person> addOne(@RequestBody Person person) {
        return personService.addOne(person);
    }

    @GetMapping
    public Mono<Person> getById(@RequestParam Long id) {
        return personService.getById(id);
    }

    @GetMapping(params = "email")
    public Mono<Person> getByMail(@RequestParam String email) {
        return personService.getBy(email);
    }

    @GetMapping(params = {"firstName", "lastName"})
    public Flux<Person> getByFirstAndLastName(@RequestParam String firstName,
                                              @RequestParam String lastName) {
        return personService.getBy(firstName, lastName);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody Person person) {
        return personService.delete(person);
    }
}
