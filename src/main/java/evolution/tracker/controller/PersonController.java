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
    public Flux<Person> getAll() {
        return personService.getAll();
    }

    @PostMapping
    public Mono<Person> addOne(@RequestBody Person person) {
        return personService.addOne(person);
    }

    @PostMapping
    public Mono<Person> update(@RequestBody Person person) {
        return personService.update(person);
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


    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestParam Long id) {
        return personService.delete(id);
    }
}
