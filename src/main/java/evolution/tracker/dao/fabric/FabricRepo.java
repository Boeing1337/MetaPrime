package evolution.tracker.dao.fabric;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * The {@link FabricRepo} table for {@link Fabric} entity.
 *
 * @author Dmitry Morozov 08.2020
 * @version 0.1
 */
public interface FabricRepo extends ReactiveCrudRepository<Fabric, Long> {

    /**
     * Find {@link Fabric} by code field.
     * All columns of the table will be included.
     *
     * @param code is a primary INT key
     * @return {@link Mono} based on a found {@link Fabric}
     */
    Mono<Fabric> findByCode(Long code);

    /**
     * Find {@link Fabric} by type field.
     * All columns of the table will be included.
     *
     * @param type is a unique VARCHAR
     * @return {@link Mono} based on a found {@link Fabric}
     */
    Mono<Fabric> deleteByType(String type);
}
