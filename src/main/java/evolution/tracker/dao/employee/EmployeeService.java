package evolution.tracker.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepo repository;

    @Autowired
    public EmployeeService(final EmployeeRepo employeeRepo) {
        this.repository = employeeRepo;
    }

    public Flux<Employee> getAll() {
        return repository.findAll();
    }

    public Mono<Employee> getById(Long id) {
        return repository.findById(id);
    }

    public Flux<Employee> getAllByPositionCode(final Long positionCode) {
        return repository.findAllByPositionCode(positionCode);
    }

    public Flux<Employee> getAllByFabricCode(final Long fabricCode) {
        return repository.findAllByFabricCode(fabricCode);
    }

    public Mono<Employee> update(final Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Updated entity must to contain id");
        }
        return repository.save(employee);
    }

    public Mono<Employee> addOne(final Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("New entity shouldn't contain id");
        }
        return repository.save(employee);
    }

    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }

}
