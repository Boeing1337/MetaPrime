package evolution.tracker.dao.person;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The {@link PersonRepo} table for {@link Person} entity.
 *
 * @author Dmitry Morozov 08.2020
 * @version 0.1
 */
@Repository
public interface PersonRepo extends ReactiveCrudRepository<Person, Long> {

    /**
     * Find all {@link Person} by firstName and lastName @params.
     * All columns of the table will be included.
     *
     * @param firstName is a VARCHAR type.
     * @param lastName  is a VARCHAR type.
     * @return {@link Flux} based on all found {@link Person}
     */
    Flux<Person> findAllByFirstNameAndLastName(
            String firstName, String lastName);

    /**
     * Gets one {@link Person} by provided @email.
     * All columns of the table will be included.
     *
     * @param email is a VARCHAR type of {@link PersonRepo} table.
     * @return {@link Flux} based on all found {@link Person}
     * by provided id.
     */
    Flux<Person> findAllByEmail(String email);
}
