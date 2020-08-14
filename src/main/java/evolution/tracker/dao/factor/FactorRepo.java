package evolution.tracker.dao.factor;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * The {@link FactorRepo} table for {@link Factor} entity.
 *
 * @author Dmitry Morozov 08.2020
 * @version 0.1
 */
public interface FactorRepo extends ReactiveCrudRepository<Factor, Long> {
    /**
     * Gets one {@link Factor} from {@link FactorRepo} by provided @type.
     * All columns of the table will be included.
     *
     * @param type is a primary VARCHAR key value of {@link FactorRepo} table.
     * @return {@link Mono} based on a found {@link Factor}
     * by provided @type.
     */
    Mono<Factor> findByType(String type);
}
