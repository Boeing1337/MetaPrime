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

    public Mono<Factor> getByType(String id) {
        return factorRepo.findByType(id);
    }

    public Mono<Factor> getById(Long id) {
        return factorRepo.findById(id);
    }

    public Mono<Factor> update(Factor factor) {
        if (factor.getId() == null) {
            throw new IllegalArgumentException("Updated entity must to contain id");
        }
        return factorRepo.save(factor);
    }

    public Mono<Factor> addOne(Factor factor) {
        if (factor.getId() != null) {
            throw new IllegalArgumentException("New entity shouldn't contain id");
        }
        return factorRepo.save(factor);
    }

    public Mono<Void> delete(Long id) {
        return factorRepo.deleteById(id);
    }
}
