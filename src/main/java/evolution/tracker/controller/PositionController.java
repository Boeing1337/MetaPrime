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

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("all")
    public Flux<Position> getAll() {
        return positionService.getAll();
    }

    @GetMapping(params = "code")
    public Mono<Position> getByCode(@RequestParam Long code) {
        return positionService.getByCode(code);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    @PostMapping
    public Mono<Position> addOne(@RequestBody Position position) {
        return positionService.addOne(position);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody Position position) {
        return positionService.delete(position);
    }
}
