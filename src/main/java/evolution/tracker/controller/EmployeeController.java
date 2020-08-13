package evolution.tracker.controller;

import evolution.tracker.dao.employee.Employee;
import evolution.tracker.dao.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.service = employeeService;
    }

    @GetMapping("all")
    public Flux<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping(params = "id")
    public Mono<Employee> getById(@RequestParam final Long id) {
        return service.getById(id);
    }

    @GetMapping(params = "positionCode")
    public Flux<Employee> getAllByPositionCode(@RequestParam final Long positionCode) {
        return service.getAllByPositionCode(positionCode);
    }

    @GetMapping(params = "fabricCode")
    public Flux<Employee> getAllByFabricCode(@RequestParam final Long fabricCode) {
        return service.getAllByFabricCode(fabricCode);
    }

    @PostMapping
    public Mono<Employee> update(@RequestBody final Employee employee) {
        return service.update(employee);
    }

    @PutMapping
    public Mono<Employee> addOne(@RequestBody final Employee employee) {
        return service.addOne(employee);
    }

    @DeleteMapping(params = "id")
    public Mono<Void> delete(@RequestBody final Long id) {
        return service.delete(id);
    }

}
