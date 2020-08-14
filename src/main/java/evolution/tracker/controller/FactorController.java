package evolution.tracker.controller;

import evolution.tracker.dao.factor.Factor;
import evolution.tracker.dao.factor.FactorRepo;
import evolution.tracker.dao.factor.FactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive REST controller for {@link FactorRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@RestController
@RequestMapping("factor")
public class FactorController {

    /**
     * DAO service for working with Data Base.
     */
    private final FactorService service;

    /**
     * Instantiates a new {@link FactorController}.
     *
     * @param factorService DAO service for {@link FactorRepo}.
     * @see FactorService
     */
    @Autowired
    public FactorController(final FactorService factorService) {
        this.service = factorService;
    }

    /**
     * Gets all {@link Factor} from {@link FactorRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Factor}
     */
    @GetMapping("all")
    public Flux<Factor> getAll() {
        return service.getAll();
    }

    /**
     * Gets one {@link Factor} from {@link FactorRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param type is a primary VARCHAR key value of {@link FactorRepo} table.
     * @return {@link Mono} based on a found {@link Factor}
     * by provided @type.
     */
    @GetMapping(params = "type")
    public Mono<Factor> getByType(@RequestParam final String type) {
        return service.getByType(type);
    }

    /**
     * Gets one {@link Factor} from {@link FactorRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a unique INT value of {@link FactorRepo} table.
     * @return {@link Mono} based on a found {@link Factor}
     * by provided id.
     */
    @GetMapping(params = "id")
    public Mono<Factor> getById(@RequestParam final Long id) {
        return service.getById(id);
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
    @PostMapping
    public Mono<Factor> update(@RequestBody final Factor factor) {
        return service.update(factor);
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
    @PutMapping
    public Mono<Factor> addOne(@RequestBody final Factor factor) {
        return service.addOne(factor);

    }

    /**
     * Just deletes {@link Factor} from {@link FactorRepo} by provided id.
     *
     * @param id is a unique INT of {@link FactorRepo} table.
     * @return {@link Mono<Void>}
     */
    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestParam final Long id) {
        return service.delete(id);
    }
}
