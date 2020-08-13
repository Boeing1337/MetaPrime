package evolution.tracker.controller;

import evolution.tracker.dao.employee.Employee;
import evolution.tracker.dao.employee.EmployeeService;
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
 * Reactive REST controller for 'Employee' table.
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
     * Instantiates a new Employee controller.
     *
     * @param employeeService DAO service bean for 'Employee' table.
     * @see evolution.tracker.dao.employee.EmployeeRepo
     * @see EmployeeService
     */
    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.service = employeeService;
    }

    /**
     * @return JSON representation of ALL employee from 'Employee' table
     * All columns of the table will be included.
     */
    @GetMapping("all")
    public Flux<Employee> getAll() {
        return service.getAll();
    }

    /**
     * @param id is a primary INT type key of 'Employee' table.
     * @return JSON representation of ONE employee from 'Employee' table
     * by provided id.
     * All columns of the table will be included.
     */
    @GetMapping(params = "id")
    public Mono<Employee> getById(@RequestParam final Long id) {
        return service.getById(id);
    }

    /**
     * @param positionCode foreign key to 'Position' table.
     *                     It presented by INT type.
     * @return JSON representation of ALL employee from 'Employee' table
     * by provided positionCode.
     * All columns of the table will be included.
     * @see evolution.tracker.dao.position.Position foreing entity
     * @see evolution.tracker.dao.fabric.FabricRepo target repository
     */
    @GetMapping(params = "positionCode")
    public Flux<Employee> getAllByPositionCode(@RequestParam final
                                               Long positionCode) {
        return service.getAllByPositionCode(positionCode);
    }

    /**
     * @param fabricCode foreign key to 'Fabric' table.
     *                   It presented by INT type.
     * @return JSON representation of ALL employee from 'Employee' table
     * by provided fabricCode.
     * All columns of the table will be included.
     * @see evolution.tracker.dao.fabric.FabricRepo target repository
     */
    @GetMapping(params = "fabricCode")
    public Flux<Employee> getAllByFabricCode(@RequestParam final
                                             Long fabricCode) {
        return service.getAllByFabricCode(fabricCode);
    }

    /**
     * @param employee is a simple entity of 'Employee table'
     *                 represented by JSON.
     * @return an error or the updated entity
     * @throws IllegalArgumentException <p>id field is required</p>
     * @see evolution.tracker.dao.fabric.FabricRepo target repository
     */
    @PostMapping
    public Mono<Employee> update(@RequestBody final Employee employee) {
        return service.update(employee);
    }

    /**
     * Puts a new entity of 'Employee' table.
     *
     * @param employee is a simple entity of 'Employee table'
     *                 represented by JSON.
     * @return an error or the added entity
     * @throws IllegalArgumentException <p>id field must be null</p>
     * @see evolution.tracker.dao.fabric.FabricRepo target repository
     */
    @PutMapping
    public Mono<Employee> addOne(@RequestBody final Employee employee) {
        return service.addOne(employee);
    }

    /**
     * Just deletes entity from 'Employee' table by provided id.
     *
     * @param id is a primary INT type key of 'Employee' table.
     * @return Mono<Void>
     * @see evolution.tracker.dao.fabric.FabricRepo target repository
     */
    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestBody final Long id) {
        return service.delete(id);
    }

}
