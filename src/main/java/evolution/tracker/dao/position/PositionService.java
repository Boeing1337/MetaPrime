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
        if (position.getId() == null) {
            throw new IllegalArgumentException("Updated entity must to contain id");
        }
        return repository.save(position);
    }

    public Mono<Position> addOne(final Position position) {
        if (position.getId() != null) {
            throw new IllegalArgumentException("New entity shouldn't contain id");
        }
        return repository.save(position);
    }

    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }

    public Mono<Void> deleteBy(final Long code) {
        return repository.deleteById(code);
    }

}
