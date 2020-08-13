package evolution.tracker.dao.fabric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FabricService {

    private final FabricRepo repository;

    @Autowired
    public FabricService(final FabricRepo fabricRepo) {
        this.repository = fabricRepo;
    }

    public Flux<Fabric> getAll() {
        return repository.findAll();
    }

    public Mono<Fabric> getByCode(final Long code) {
        return repository.findByCode(code);
    }

    public Mono<Fabric> getById(final Long id) {
        return repository.findById(id);
    }

    public Mono<Fabric> update(final Fabric fabric) {
        if (fabric.getId() == null) {
            throw new IllegalArgumentException("Updated entity must to contain id");
        }
        return repository.save(fabric);
    }

    public Mono<Fabric> addOne(final Fabric fabric) {
        if (fabric.getId() != null) {
            throw new IllegalArgumentException("New entity shouldn't contain id");
        }
        return repository.save(fabric);
    }

    public Mono<Void> delete(final Long id) {
        return repository.deleteById(id);
    }

    public Mono<Fabric> deleteBy(final String type) {
        return repository.deleteByType(type);
    }
}
