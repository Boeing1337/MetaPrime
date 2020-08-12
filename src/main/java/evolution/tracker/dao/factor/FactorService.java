package evolution.tracker.dao.factor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FactorService {

    private final FactorRepo factorRepo;

    @Autowired
    public FactorService(FactorRepo factorRepo) {
        this.factorRepo = factorRepo;
    }

    public Flux<Factor> getAll() {
        return factorRepo.findAll();
    }

    public Mono<Factor> getById(Long id) {
        return factorRepo.findById(id);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    public Mono<Factor> addOne(Factor factor) {
        return factorRepo.save(factor);
    }

    public Mono<Void> delete(Factor factor) {
        return factorRepo.delete(factor);
    }
}
