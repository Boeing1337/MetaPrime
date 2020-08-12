package evolution.tracker.dao.employee;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Long> {
    Flux<Employee> findAllByPositionCode(Long positionCOde);

    Flux<Employee> findAllByFabricCode(Long fabricCode);
}
