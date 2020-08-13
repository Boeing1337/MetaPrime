package evolution.tracker.controller;

import evolution.tracker.dao.factor.Factor;
import evolution.tracker.dao.factor.FactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("factor")
public class FactorController {
    private final FactorService factorService;

    @Autowired
    public FactorController(FactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping("all")
    public Flux<Factor> getAll() {
        return factorService.getAll();
    }

    @GetMapping(params = "type")
    public Mono<Factor> getByType(@RequestParam String type) {
        return factorService.getByType(type);
    }

    @GetMapping(params = "id")
    public Mono<Factor> getById(@RequestParam Long id) {
        return factorService.getById(id);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    @PostMapping
    public Mono<Factor> addOne(@RequestBody Factor factor) {
        return factorService.addOne(factor);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody Factor factor) {
        return factorService.delete(factor);
    }
}
