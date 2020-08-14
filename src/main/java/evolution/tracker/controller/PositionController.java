package evolution.tracker.controller;

import evolution.tracker.dao.position.Position;
import evolution.tracker.dao.position.PositionRepo;
import evolution.tracker.dao.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive REST controller for {@link PositionRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@RestController
@RequestMapping("position")
public class PositionController {

    /**
     * DAO service for working with Data Base.
     */
    private final PositionService service;

    /**
     * Instantiates a new {@link FabricController}.
     *
     * @param positionService DAO service for {@link PositionRepo}.
     * @see PositionService
     */
    @Autowired
    public PositionController(final PositionService positionService) {
        this.service = positionService;
    }

    /**
     * Gets all {@link Position} from {@link PositionRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Position}
     */
    @GetMapping("all")
    public Flux<Position> getAll() {
        return service.getAll();
    }

    /**
     * Gets one {@link Position} from {@link PositionRepo} by provided code.
     * All columns of the table will be included.
     *
     * @param code is a primary INT type key of {@link PositionRepo} table.
     * @return {@link Mono} based on a found {@link Position}
     * by provided code.
     */
    @GetMapping(params = "code")
    public Mono<Position> getByCode(@RequestParam final Long code) {
        return service.getByCode(code);
    }

    /**
     * Gets one {@link Position} from {@link PositionRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a unique INT value of {@link PositionRepo} table.
     * @return {@link Mono} based on a found {@link Position}
     * by provided id.
     */
    @GetMapping(params = "id")
    public Mono<Position> getById(@RequestParam final Long id) {
        return service.getById(id);
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
    @PostMapping
    public Mono<Position> update(@RequestBody final Position position) {
        return service.update(position);
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
    @PutMapping
    public Mono<Position> addOne(@RequestBody final Position position) {
        return service.addOne(position);
    }

    /**
     * Just deletes {@link Position} from {@link PositionRepo} by provided id.
     *
     * @param id is a unique INT of {@link PositionRepo} table.
     * @return {@link Mono<Void>}
     */
    @DeleteMapping(params = "id")
    public Mono<Void> deleteById(@RequestParam final Long id) {
        return service.deleteById(id);
    }

    /**
     * Just deletes {@link Position} from {@link PositionRepo} by provided code.
     *
     * @param code is a unique VARCHAR of {@link PositionRepo} table.
     * @return the deleted {@link Mono} based on {@link Position}
     */
    @DeleteMapping(params = "code")
    public Mono<Void> deleteBy(@RequestParam final Long code) {
        return service.deleteBy(code);
    }
}
