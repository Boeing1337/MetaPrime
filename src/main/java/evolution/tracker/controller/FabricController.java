package evolution.tracker.controller;

import evolution.tracker.dao.fabric.Fabric;
import evolution.tracker.dao.fabric.FabricRepo;
import evolution.tracker.dao.fabric.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive REST controller for {@link FabricRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@RestController
@RequestMapping("fabric")
public class FabricController {

    /**
     * DAO service for working with Data Base.
     */
    private final FabricService service;

    /**
     * Instantiates a new {@link FabricController}.
     *
     * @param fabricService DAO service for {@link FabricRepo}.
     * @see FabricService
     */
    @Autowired
    public FabricController(final FabricService fabricService) {
        this.service = fabricService;
    }

    /**
     * Gets all {@link Fabric} from {@link FabricRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Fabric}
     */
    @GetMapping("all")
    public Flux<Fabric> getAll() {
        return service.getAll();
    }

    /**
     * Gets one {@link Fabric} from {@link FabricRepo} by provided code.
     * All columns of the table will be included.
     *
     * @param code is a primary INT type key of {@link FabricRepo} table.
     * @return {@link Mono} based on a found {@link Fabric}
     * by provided code.
     */
    @GetMapping(params = "code")
    public Mono<Fabric> getByCode(@RequestParam final Long code) {
        return service.getByCode(code);
    }

    /**
     * Gets one {@link Fabric} from {@link FabricRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a unique INT value of {@link FabricRepo} table.
     * @return {@link Mono} based on a found {@link Fabric}
     * by provided id.
     */
    @GetMapping(params = "id")
    public Mono<Fabric> getById(@RequestParam final Long id) {
        return service.getById(id);
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
    @PostMapping
    public Mono<Fabric> update(@RequestBody final Fabric fabric) {
        return service.update(fabric);
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
    @PutMapping
    public Mono<Fabric> addOne(@RequestBody final Fabric fabric) {
        return service.addOne(fabric);
    }

    /**
     * Just deletes {@link Fabric} from {@link FabricRepo} by provided id.
     *
     * @param id is a unique INT of {@link FabricRepo} table.
     * @return {@link Mono<Void>}
     */
    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestBody final Long id) {
        return service.delete(id);
    }

    /**
     * Just deletes {@link Fabric} from {@link FabricRepo} by provided type.
     *
     * @param type is a unique VARCHAR of {@link FabricRepo} table.
     * @return the deleted {@link Mono} based on {@link Fabric}
     */
    @DeleteMapping(params = "type")
    public Mono<Fabric> deleteBy(@RequestParam final String type) {
        return service.deleteBy(type);
    }
}
