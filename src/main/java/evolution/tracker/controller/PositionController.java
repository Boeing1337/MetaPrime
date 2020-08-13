package evolution.tracker.controller;

import evolution.tracker.dao.position.Position;
import evolution.tracker.dao.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("position")
public class PositionController {

    private final PositionService service;

    @Autowired
    public PositionController(final PositionService positionService) {
        this.service = positionService;
    }

    @GetMapping("all")
    public Flux<Position> getAll() {
        return service.getAll();
    }

    @GetMapping(params = "code")
    public Mono<Position> getByCode(@RequestParam final Long code) {
        return service.getByCode(code);
    }

    @GetMapping(params = "id")
    public Mono<Position> getById(@RequestParam final Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<Position> update(@RequestBody final Position position) {
        return service.update(position);
    }

    @PutMapping
    public Mono<Position> addOne(@RequestBody final Position position) {
        return service.addOne(position);
    }

    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestParam final Long id) {
        return service.delete(id);
    }

    @DeleteMapping(params = "code")
    public Mono<Void> deleteBy(@RequestParam final Long code) {
        return service.deleteBy(code);
    }
}
