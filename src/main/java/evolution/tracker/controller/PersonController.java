package evolution.tracker.controller;

import evolution.tracker.dao.person.Person;
import evolution.tracker.dao.person.PersonRepo;
import evolution.tracker.dao.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive REST controller for {@link PersonRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@RestController
@RequestMapping("person")
public class PersonController {

    /**
     * DAO service for working with Data Base.
     */
    private final PersonService service;

    /**
     * Instantiates a new {@link EmployeeController}.
     *
     * @param personService DAO service for {@link PersonRepo}.
     * @see PersonService
     */
    @Autowired
    public PersonController(final PersonService personService) {
        this.service = personService;
    }

    /**
     * Gets all {@link Person} from {@link PersonRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Person}
     */
    @GetMapping("all")
    public Flux<Person> getAll() {
        return service.getAll();
    }

    /**
     * Gets one {@link Person} from {@link PersonRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a primary INT type key of {@link PersonRepo} table.
     * @return {@link Mono} based on a found {@link Person}
     * by provided id.
     */
    @GetMapping(params = "id")
    public Mono<Person> getById(@RequestParam final Long id) {
        return service.getById(id);
    }

    /**
     * Gets all {@link Person} from {@link PersonRepo} by provided @email.
     * All columns of the table will be included.
     *
     * @param email is a VARCHAR type of {@link PersonRepo} table.
     * @return {@link Flux} based on all found {@link Person}
     * by provided id.
     */
    @GetMapping(params = "email")
    public Flux<Person> getByEmail(@RequestParam final String email) {
        return service.getBy(email);
    }

    /**
     * Gets all {@link Person} from {@link PersonRepo} by provided @params.
     * All columns of the table will be included.
     *
     * @param firstName is a VARCHAR type of {@link PersonRepo} table.
     * @param lastName  is a VARCHAR type of {@link PersonRepo} table.
     * @return {@link Flux} based on all found {@link Person}
     * by provided id.
     */
    @GetMapping(params = {"firstName", "lastName"})
    public Flux<Person> getByFirstAndLastName(
            @RequestParam final String firstName,
            @RequestParam final String lastName) {
        return service.getBy(firstName, lastName);
    }

    /**
     * Add a new {@link Person} row in {@link PersonRepo} table.
     * All columns will be included
     *
     * @param person is {@link Person} entity to be added.
     *               the @id field must be null
     * @return the updated {@link Mono} based on {@link Person}
     * @throws IllegalArgumentException the @id field must be null
     */
    @PutMapping
    public Mono<Person> addOne(@RequestBody final Person person) {
        return service.addOne(person);
    }

    /**
     * Updates a {@link Person} row in {@link PersonRepo} table.
     * All columns will be updated
     *
     * @param person is {@link Person} entity to be updated
     *               it must contain @id of an existed entity in the table
     *               you want to update
     * @return the updated {@link Mono} based on {@link Person}
     * @throws IllegalArgumentException id field of {@link Person} is required
     */
    @PostMapping
    public Mono<Person> update(@RequestBody final Person person) {
        return service.update(person);
    }

    /**
     * Just deletes {@link Person} from {@link PersonRepo} by provided id.
     *
     * @param id is a primary INT type key of {@link PersonRepo} table.
     * @return {@link Mono<Void>}
     */
    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestParam final Long id) {
        return service.delete(id);
    }
}
