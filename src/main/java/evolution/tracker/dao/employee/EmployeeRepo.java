package evolution.tracker.dao.employee;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * The {@link EmployeeRepo} table for {@link Employee} entity.
 *
 * @author Dmitry Morozov 08.2020
 * @version 0.1
 */
public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Long> {
    /**
     * Find all {@link Employee} by positionCode field.
     *
     * @param positionCode is foreign position_code INT key
     * @return {@link Flux} based on all found {@link Employee}
     */
    Flux<Employee> findAllByPositionCode(Long positionCode);

    /**
     * Find all {@link Employee} by fabricCode field.
     *
     * @param fabricCode is foreign fabric_code INT key
     * @return {@link Flux} based on all found {@link Employee}
     */
    Flux<Employee> findAllByFabricCode(Long fabricCode);
}
