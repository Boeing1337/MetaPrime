package evolution.tracker.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive DAO service to work with 'Employee' table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Service
public class EmployeeService {

    /**
     * Repository of 'Employee' table.
     *
     * @see Employee
     */
    private final EmployeeRepo repository;

    /**
     * Instantiates a new Employee service.
     *
     * @param employeeRepo the 'Employee' repository
     */
    @Autowired
    public EmployeeService(final EmployeeRepo employeeRepo) {
        this.repository = employeeRepo;
    }

    /**
     * Gets all Employee from 'Employee' table.
     * All columns will be included
     *
     * @return the all
     */
    public Flux<Employee> getAll() {
        return repository.findAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Mono<Employee> getById(Long id) {
        return repository.findById(id);
    }

    /**
     * Gets all by position code.
     *
     * @param positionCode the position code
     * @return the all by position code
     */
    public Flux<Employee> getAllByPositionCode(final Long positionCode) {
        return repository.findAllByPositionCode(positionCode);
    }

    /**
     * Gets all by fabric code.
     *
     * @param fabricCode the fabric code
     * @return the all by fabric code
     */
    public Flux<Employee> getAllByFabricCode(final Long fabricCode) {
        return repository.findAllByFabricCode(fabricCode);
    }

    /**
     * Update mono.
     *
     * @param employee the employee
     * @return the mono
     */
    public Mono<Employee> update(final Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Updated entity must to contain id");
        }
        return repository.save(employee);
    }

    /**
     * Add one mono.
     *
     * @param employee the employee
     * @return the mono
     */
    public Mono<Employee> addOne(final Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("New entity shouldn't contain id");
        }
        return repository.save(employee);
    }

    /**
     * Delete mono.
     *
     * @param id the id
     * @return the mono
     */
    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }

}
