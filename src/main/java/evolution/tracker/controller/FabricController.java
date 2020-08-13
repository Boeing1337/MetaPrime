package evolution.tracker.controller;

import evolution.tracker.dao.fabric.Fabric;
import evolution.tracker.dao.fabric.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("fabric")
public class FabricController {
    private final FabricService service;

    @Autowired
    public FabricController(final FabricService fabricService) {
        this.service = fabricService;
    }

    @GetMapping("all")
    public Flux<Fabric> getAll() {
        return service.getAll();
    }

    @GetMapping(params = "code")
    public Mono<Fabric> getByCode(@RequestParam final Long code) {
        return service.getByCode(code);
    }

    @GetMapping(params = "id")
    public Mono<Fabric> getById(@RequestParam final Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<Fabric> update(@RequestBody final Fabric fabric) {
        return service.update(fabric);
    }

    @PutMapping
    public Mono<Fabric> addOne(@RequestBody final Fabric fabric) {
        return service.addOne(fabric);
    }

    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestBody final Long id) {
        return service.delete(id);
    }

    @DeleteMapping(params = "type")
    public Mono<Fabric> deleteBy(@RequestParam final String type) {
        return service.deleteBy(type);
    }
}
