package evolution.tracker.dao.position;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PositionRepo extends ReactiveCrudRepository<Position, Long> {
    Mono<Position> findByCode(Long code);
}
