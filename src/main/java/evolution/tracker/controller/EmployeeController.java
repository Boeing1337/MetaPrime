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

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("all")
    public Flux<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(params = "id")
    public Mono<Employee> getById(@RequestParam Long id) {
        return employeeService.getById(id);
    }

    @GetMapping(params = "positionCode")
    public Flux<Employee> getAllByPositionCode(@RequestParam Long positionCode) {
        return employeeService.getAllByPositionCode(positionCode);
    }

    @GetMapping(params = "fabricCode")
    public Flux<Employee> getAllByFabricCode(@RequestParam Long fabricCode) {
        return employeeService.getAllByFabricCode(fabricCode);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    @PostMapping
    public Mono<Employee> addOne(@RequestBody Employee employee) {
        return employeeService.addOne(employee);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody Employee employee) {
        return employeeService.delete(employee);
    }
}
