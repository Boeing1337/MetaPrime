package evolution.tracker.dao.factor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive DAO service to work with {@link FactorRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Service
public class FactorService {

    /**
     * Repository of {@link FactorRepo} table.
     *
     * @see Factor entity
     */
    private final FactorRepo repository;

    /**
     * Instantiates a new this {@link FactorRepo}.
     *
     * @param factorRepo is {@link FactorRepo} repository
     * @see Factor entity
     */
    @Autowired
    public FactorService(final FactorRepo factorRepo) {
        this.repository = factorRepo;
    }

    /**
     * Gets all {@link Factor} entities from {@link FactorRepo} table.
     * All columns will be included
     *
     * @return {@link Flux} based on all {@link Factor} in the table
     */
    public Flux<Factor> getAll() {
        return repository.findAll();
    }

    /**
     * Gets one {@link Factor} from {@link FactorRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param type is a primary VARCHAR key value of {@link FactorRepo} table.
     * @return {@link Mono} based on a found {@link Factor}
     * by provided @type.
     */
    public Mono<Factor> getByType(final String type) {
        return repository.findByType(type);
    }

    /**
     * Gets one {@link Factor} entity from {@link FactorRepo} table by id.
     * All columns will be included
     *
     * @param id is a unique INT type of {@link FactorRepo} table.
     * @return a {@link Mono} based on {@link Factor} entity
     */
    public Mono<Factor> getById(final Long id) {
        return repository.findById(id);
    }

    /**
     * Updates a {@link Factor} row in {@link FactorRepo} table.
     * All columns will be updated
     *
     * @param factor is {@link Factor} entity to be updated
     *               it must contain @id of an existed entity in the table
     *               you want to update
     * @return the updated {@link Mono} based on {@link Factor}
     * @throws IllegalArgumentException id field of {@link Factor} is required
     */
    public Mono<Factor> update(final Factor factor) {
        if (factor.getId() == null) {
            throw new IllegalArgumentException(
                    "Updated entity must to contain id");
        }
        return repository.save(factor);
    }

    /**
     * Add a new {@link Factor} row in {@link FactorRepo} table.
     * All columns will be included
     *
     * @param factor is {@link Factor} entity to be added.
     *               the @id field must be null
     * @return the updated {@link Mono} based on {@link Factor}
     * @throws IllegalArgumentException the @id field must be null
     */
    public Mono<Factor> addOne(final Factor factor) {
        if (factor.getId() != null) {
            throw new IllegalArgumentException(
                    "New entity shouldn't contain id");
        }
        return repository.save(factor);
    }

    /**
     * Deletes {@link Factor} entity from {@link FactorRepo} table by @id.
     *
     * @param id is a unique INT of {@link FactorRepo} table.
     * @return {@link Mono<Void>}
     */
    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }
}
