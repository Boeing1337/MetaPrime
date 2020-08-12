package evolution.tracker.controller;

import evolution.tracker.dao.fabric.Fabric;
import evolution.tracker.dao.fabric.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("fabric")
public class FabricController {
    private final FabricService fabricService;

    @Autowired
    public FabricController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping("all")
    public Flux<Fabric> getAll() {
        return fabricService.getAll();
    }

    @GetMapping(params = "code")
    public Mono<Fabric> getByCode(@RequestParam Long code) {
        return fabricService.getByCode(code);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    @PostMapping
    public Mono<Fabric> addOne(@RequestBody Fabric fabric) {
        return fabricService.addOne(fabric);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody Fabric fabric) {
        return fabricService.delete(fabric);
    }
}
