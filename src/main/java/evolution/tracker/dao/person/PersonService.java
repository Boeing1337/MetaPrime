package evolution.tracker.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive DAO service to work with {@link PersonRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Service
public class PersonService {

    /**
     * Repository of {@link PersonRepo} table.
     *
     * @see Person entity
     */
    private final PersonRepo repository;

    /**
     * Instantiates a new this {@link PersonService}.
     *
     * @param personRepo is {@link PersonRepo} repository
     * @see Person entity
     */
    @Autowired
    public PersonService(final PersonRepo personRepo) {
        this.repository = personRepo;
    }

    /**
     * Gets all {@link Person} from {@link PersonRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Person}
     */
    public Flux<Person> getAll() {
        return repository.findAll();
    }

    /**
     * Gets one {@link Person} from {@link PersonRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a primary INT type key of {@link PersonRepo} table.
     * @return {@link Mono} based on a found {@link Person}
     * by provided id.
     */
    public Mono<Person> getById(final Long id) {
        return repository.findById(id);
    }

    /**
     * Gets one {@link Person} from {@link PersonRepo} by provided @email.
     * All columns of the table will be included.
     *
     * @param email is a VARCHAR type of {@link PersonRepo} table.
     * @return {@link Flux} based on a found {@link Person}
     * by provided id.
     */
    public Flux<Person> getBy(final String email) {
        return repository.findAllByEmail(email);
    }

    /**
     * Gets one {@link Person} from {@link PersonRepo} by provided @params.
     * All columns of the table will be included.
     *
     * @param firstName is a VARCHAR type of {@link PersonRepo} table.
     * @param lastName  is a VARCHAR type of {@link PersonRepo} table.
     * @return {@link Flux} based on a found {@link Person}
     * by provided id.
     */
    public Flux<Person> getBy(final String firstName, final String lastName) {
        return repository.findAllByFirstNameAndLastName(firstName, lastName);
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
    public Mono<Person> update(final Person person) {
        if (person.getId() == null) {
            throw new IllegalArgumentException(
                    "Updated entity must to contain id");
        }
        return repository.save(person);
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
    public Mono<Person> addOne(final Person person) {
        if (person.getId() != null) {
            throw new IllegalArgumentException(
                    "New entity shouldn't contain id");
        }
        return repository.save(person);
    }

    /**
     * Just deletes {@link Person} from {@link PersonRepo} by provided id.
     *
     * @param id is a primary INT type key of {@link PersonRepo} table.
     * @return {@link Mono<Void>}
     */
    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }
}
