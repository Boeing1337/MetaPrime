package evolution.tracker.dao.position;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * The {@link PositionRepo} table for {@link Position} entity.
 *
 * @author Dmitry Morozov 08.2020
 * @version 0.1
 */
public interface PositionRepo extends ReactiveCrudRepository<Position, Long> {

    /**
     * Find {@link Position} by code @param.
     *
     * @param code is a primary INT key
     * @return {@link Mono} based on a found {@link Position}
     */
    Mono<Position> findByCode(Long code);
}
