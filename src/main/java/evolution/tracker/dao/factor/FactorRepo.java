package evolution.tracker.dao.factor;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface FactorRepo extends ReactiveCrudRepository<Factor, Long> {
    Mono<Factor> findByType(String type);
}
