package evolution.tracker.dao.position;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PositionRepo extends ReactiveCrudRepository<Position, Long> {
}
