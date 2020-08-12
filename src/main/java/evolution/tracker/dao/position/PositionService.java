package evolution.tracker.dao.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PositionService {

    private final PositionRepo positionRepo;

    @Autowired
    public PositionService(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    public Flux<Position> getAll() {
        return positionRepo.findAll();
    }

    public Mono<Position> getByCode(Long code) {
        return positionRepo.findById(code);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    public Mono<Position> addOne(Position position) {
        return positionRepo.save(position);
    }

    public Mono<Void> delete(Position position) {
        return positionRepo.delete(position);
    }

}
