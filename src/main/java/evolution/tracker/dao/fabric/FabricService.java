package evolution.tracker.dao.fabric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive DAO service to work with {@link FabricRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Service
public class FabricService {

    /**
     * Repository of {@link FabricRepo} table.
     *
     * @see Fabric entity
     */
    private final FabricRepo repository;

    /**
     * Instantiates a new this {@link FabricService}.
     *
     * @param fabricRepo is {@link FabricRepo} repository
     * @see Fabric entity
     */
    @Autowired
    public FabricService(final FabricRepo fabricRepo) {
        this.repository = fabricRepo;
    }

    /**
     * Gets all {@link Fabric} entities from {@link FabricRepo} table.
     * All columns will be included
     *
     * @return {@link Flux} based on all {@link Fabric} in the table
     */
    public Flux<Fabric> getAll() {
        return repository.findAll();
    }

    /**
     * Gets one {@link Fabric} from {@link FabricRepo} by provided code.
     * All columns of the table will be included.
     *
     * @param code is a primary INT type key of {@link FabricRepo} table.
     * @return {@link Mono} based on a found {@link Fabric}
     * by provided id.
     */
    public Mono<Fabric> getByCode(final Long code) {
        return repository.findByCode(code);
    }

    /**
     * Gets one {@link Fabric} entity from {@link FabricRepo} table by id.
     * All columns will be included
     *
     * @param id is a unique INT type of {@link FabricRepo} table.
     * @return a {@link Mono} based on {@link Fabric} entity
     */
    public Mono<Fabric> getById(final Long id) {
        return repository.findById(id);
    }

    /**
     * Updates a {@link Fabric} row in {@link FabricRepo} table.
     * All columns will be updated
     *
     * @param fabric is {@link Fabric} entity to be updated
     *               it must contain @id of an existed entity in the table
     *               you want to update
     * @return the updated {@link Mono} based on {@link Fabric}
     * @throws IllegalArgumentException id field of {@link Fabric} is required
     */
    public Mono<Fabric> update(final Fabric fabric) {
        if (fabric.getId() == null) {
            throw new IllegalArgumentException(
                    "Updated entity must to contain id");
        }
        return repository.save(fabric);
    }

    /**
     * Add a new {@link Fabric} row in {@link FabricRepo} table.
     * All columns will be included
     *
     * @param fabric is {@link Fabric} entity to be added.
     *               the @id field must be null
     * @return the updated {@link Mono} based on {@link Fabric}
     * @throws IllegalArgumentException the @id field must be null
     */
    public Mono<Fabric> addOne(final Fabric fabric) {
        if (fabric.getId() != null) {
            throw new IllegalArgumentException(
                    "New entity shouldn't contain id");
        }
        return repository.save(fabric);
    }

    /**
     * Deletes {@link Fabric} entity from {@link FabricRepo} table by @id.
     *
     * @param id is a unique INT of {@link FabricRepo} table.
     * @return {@link Mono<Void>}
     */
    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }

    /**
     * Just deletes {@link Fabric} from {@link FabricRepo} by provided type.
     *
     * @param type is a unique VARCHAR of {@link FabricRepo} table.
     * @return the deleted {@link Mono} based on {@link Fabric}
     */
    public Mono<Fabric> deleteBy(final String type) {
        return repository.deleteByType(type);
    }
}
