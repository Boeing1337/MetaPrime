package evolution.tracker.dao.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive DAO service to work with {@link PositionRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Component
public class PositionService {

    /**
     * Repository of {@link PositionRepo} table.
     *
     * @see Position entity
     */
    private final PositionRepo repository;

    /**
     * Instantiates a new this {@link PositionService}.
     *
     * @param positionRepo is {@link PositionRepo} repository
     * @see Position entity
     */
    @Autowired
    public PositionService(final PositionRepo positionRepo) {
        this.repository = positionRepo;
    }

    /**
     * Gets all {@link Position} from {@link PositionRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Position}
     */
    public Flux<Position> getAll() {
        return repository.findAll();
    }

    /**
     * Gets one {@link Position} from {@link PositionRepo} by provided code.
     * All columns of the table will be included.
     *
     * @param code is a primary INT type key of {@link PositionRepo} table.
     * @return {@link Mono} based on a found {@link Position}
     * by provided code.
     */
    public Mono<Position> getByCode(final Long code) {
        return repository.findByCode(code);
    }

    /**
     * Gets one {@link Position} from {@link PositionRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a unique INT value of {@link PositionRepo} table.
     * @return {@link Mono} based on a found {@link Position}
     * by provided id.
     */
    public Mono<Position> getById(final Long id) {
        return repository.findById(id);
    }

    /**
     * Updates a {@link Position} row in {@link PositionRepo} table.
     * All columns will be updated
     *
     * @param position is {@link Position} entity to be updated
     *                 it must contain @id of an existed entity in the table
     *                 you want to update
     * @return the updated {@link Mono} based on {@link Position}
     * @throws IllegalArgumentException id field of {@link Position} is required
     */
    public Mono<Position> update(final Position position) {
        if (position.getId() == null) {
            throw new IllegalArgumentException(
                    "Updated entity must to contain id");
        }
        return repository.save(position);
    }

    /**
     * Add a new {@link Position} row in {@link PositionRepo} table.
     * All columns will be included
     *
     * @param position is {@link Position} entity to be added.
     *                 the @id field must be null
     * @return the updated {@link Mono} based on {@link Position}
     * @throws IllegalArgumentException the @id field must be null
     */
    public Mono<Position> addOne(final Position position) {
        if (position.getId() != null) {
            throw new IllegalArgumentException(
                    "New entity shouldn't contain id");
        }
        return repository.save(position);
    }

    /**
     * Just deletes {@link Position} from {@link PositionRepo} by provided id.
     *
     * @param id is a unique INT of {@link PositionRepo} table.
     * @return {@link Mono<Void>}
     */
    public Mono<Void> deleteById(final Long id) {
        return repository.deleteById(id);
    }

    /**
     * Just deletes {@link Position} from {@link PositionRepo} by provided code.
     *
     * @param code is a unique VARCHAR of {@link PositionRepo} table.
     * @return the deleted {@link Mono} based on {@link Position}
     */
    public Mono<Void> deleteBy(final Long code) {
        return repository.deleteById(code);
    }

}
