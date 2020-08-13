package evolution.tracker.dao.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PositionService {

    private final PositionRepo repository;

    @Autowired
    public PositionService(final PositionRepo positionRepo) {
        this.repository = positionRepo;
    }

    public Flux<Position> getAll() {
        return repository.findAll();
    }

    public Mono<Position> getByCode(final Long code) {
        return repository.findByCode(code);
    }

    public Mono<Position> getById(final Long id) {
        return repository.findById(id);
    }

    public Mono<Position> update(final Position position) {
        return repository
                .findById(position.getCode())
                .doOnSubscribe(System.out::println); //TO DO: delete it!
    }

    public Mono<Position> addOne(final Position position) {
        return repository.save(position);
    }

    public Mono<Void> delete(final Position position) {
        return repository.delete(position);
    }

    public Mono<Void> deleteBy(final Long code) {
        return repository.deleteById(code);
    }

}
