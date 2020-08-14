package evolution.tracker.controller;

import evolution.tracker.dao.employee.Employee;
import evolution.tracker.dao.employee.EmployeeRepo;
import evolution.tracker.dao.employee.EmployeeService;
import evolution.tracker.dao.fabric.Fabric;
import evolution.tracker.dao.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive REST controller for {@link EmployeeRepo} table.
 * All CRUD operations are supported.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    /**
     * DAO service for working with Data Base.
     */
    private final EmployeeService service;

    /**
     * Instantiates a new {@link EmployeeController}.
     *
     * @param employeeService DAO service for {@link EmployeeRepo}.
     * @see EmployeeService
     */
    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.service = employeeService;
    }

    /**
     * Gets all {@link Employee} from {@link EmployeeRepo}.
     * All columns of the table will be included.
     *
     * @return {@link Flux} based on all found {@link Employee}
     */
    @GetMapping("all")
    public Flux<Employee> getAll() {
        return service.getAll();
    }

    /**
     * Gets one {@link Employee} from {@link EmployeeRepo} by provided id.
     * All columns of the table will be included.
     *
     * @param id is a primary INT type key of {@link EmployeeRepo} table.
     * @return {@link Mono} based on a found {@link Employee}
     * by provided id.
     */
    @GetMapping(params = "id")
    public Mono<Employee> getById(@RequestParam final Long id) {
        return service.getById(id);
    }

    /**
     * Gets {@link Employee} from {@link EmployeeRepo} by provided positionCode.
     * All columns of the table will be included.
     *
     * @param positionCode is a foreign key to {@link Position} table.
     *                     It presented by INT type.
     * @return {@link Flux} based on all found {@link Employee}
     */
    @GetMapping(params = "positionCode")
    public Flux<Employee> getAllByPositionCode(@RequestParam final
                                               Long positionCode) {
        return service.getAllByPositionCode(positionCode);
    }

    /**
     * Gets {@link Employee} from {@link EmployeeRepo} by provided fabricCode.
     * All columns of the table will be included.
     *
     * @param fabricCode is a foreign key to {@link Fabric} table.
     *                   It presented by INT type.
     * @return {@link Flux} based on all found {@link Employee}
     */
    @GetMapping(params = "fabricCode")
    public Flux<Employee> getAllByFabricCode(@RequestParam final
                                             Long fabricCode) {
        return service.getAllByFabricCode(fabricCode);
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
    @PostMapping
    public Mono<Employee> update(@RequestBody final Employee employee) {
        return service.update(employee);
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
    @PutMapping
    public Mono<Employee> addOne(@RequestBody final Employee employee) {
        return service.addOne(employee);
    }

    /**
     * Just deletes {@link Employee} from {@link EmployeeRepo} by provided id.
     *
     * @param id is a primary INT type key of {@link EmployeeRepo} table.
     * @return {@link Mono<Void>}
     */
    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestBody final Long id) {
        return service.delete(id);
    }

}
