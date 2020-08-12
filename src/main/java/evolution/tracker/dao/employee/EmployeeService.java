package evolution.tracker.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Flux<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Mono<Employee> getById(Long id) {
        return employeeRepo.findById(id);
    }

    public Flux<Employee> getAllByPositionCode(Long positionCode) {
        return employeeRepo.findAllByPositionCode(positionCode);
    }

    public Flux<Employee> getAllByFabricCode(Long fabricCode) {
        return employeeRepo.findAllByFabricCode(fabricCode);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    public Mono<Employee> addOne(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Mono<Void> delete(Employee employee) {
        return employeeRepo.delete(employee);
    }
}
