package evolution.tracker.dao.fabric;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface FabricRepo extends ReactiveCrudRepository<Fabric, Long> {
    Mono<Fabric> findByCode(Long code);
}
