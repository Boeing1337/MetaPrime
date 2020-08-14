package evolution.tracker.dao.employee;

import evolution.tracker.dao.fabric.FabricRepo;
import evolution.tracker.dao.position.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive DAO service to work with {@link EmployeeRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Service
public class EmployeeService {

    /**
     * Repository of {@link EmployeeRepo} table.
     *
     * @see Employee entity
     */
    private final EmployeeRepo repository;

    /**
     * Instantiates a new this {@link EmployeeService}.
     *
     * @param employeeRepo is {@link EmployeeRepo} repository
     * @see Employee entity
     */
    @Autowired
    public EmployeeService(final EmployeeRepo employeeRepo) {
        this.repository = employeeRepo;
    }

    /**
     * Gets all {@link Employee} entities from {@link EmployeeRepo} table.
     * All columns will be included
     *
     * @return {@link Flux} based on all {@link Employee} in the table
     */
    public Flux<Employee> getAll() {
        return repository.findAll();
    }

    /**
     * Gets one {@link Employee} entity from {@link EmployeeRepo} table by id.
     * All columns will be included
     *
     * @param id is a primary INT type key of {@link EmployeeRepo} table.
     * @return a {@link Mono} based on {@link Employee} entity
     */
    public Mono<Employee> getById(final Long id) {
        return repository.findById(id);
    }

    /**
     * Gets {@link Employee} entities from {@link EmployeeRepo} table by @param.
     * All columns will be included
     *
     * @param positionCode is a INT type foreign key.
     *                     It represent a column from {@link PositionRepo}
     * @return {@link Flux} based on {@link Employee}
     */
    public Flux<Employee> getAllByPositionCode(final Long positionCode) {
        return repository.findAllByPositionCode(positionCode);
    }

    /**
     * Gets {@link Employee} entities from {@link EmployeeRepo} table by @param.
     * All columns will be included
     *
     * @param fabricCode is a INT type foreign key.
     *                   It represent a column from {@link FabricRepo}
     * @return {@link Flux} based on {@link Employee}
     */
    public Flux<Employee> getAllByFabricCode(final Long fabricCode) {
        return repository.findAllByFabricCode(fabricCode);
    }

    /**
     * Updates a {@link Employee} row in {@link EmployeeRepo} table.
     * All columns will be updated
     *
     * @param employee is {@link Employee} entity to be updated
     *                 it must contain @id of an existed entity in the table
     *                 you want to update
     * @return the updated {@link Mono} based on {@link Employee}
     * @throws IllegalArgumentException id field of {@link Employee} is required
     */
    public Mono<Employee> update(final Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException(
                    "Updated entity must to contain id");
        }
        return repository.save(employee);
    }

    /**
     * Add a new {@link Employee} row in {@link EmployeeRepo} table.
     * All columns will be included
     *
     * @param employee is {@link Employee} entity to be added.
     *                 the @id field must be null
     * @return the updated {@link Mono} based on {@link Employee}
     * @throws IllegalArgumentException the @id field must be null
     */
    public Mono<Employee> addOne(final Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException(
                    "New entity shouldn't contain id");
        }
        return repository.save(employee);
    }

    /**
     * Deletes {@link Employee} entity from {@link EmployeeRepo} table by @id.
     *
     * @param id is a primary INT type key of {@link EmployeeRepo} table.
     * @return {@link Mono<Void>}
     */
    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }

}
