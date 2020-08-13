package evolution.tracker.dao.fabric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FabricService {

    private final FabricRepo fabricRepo;

    @Autowired
    public FabricService(FabricRepo fabricRepo) {
        this.fabricRepo = fabricRepo;
    }

    public Flux<Fabric> getAll() {
        return fabricRepo.findAll();
    }

    public Mono<Fabric> getByCode(Long code) {
        return fabricRepo.findByCode(code);
    }

    public Mono<Fabric> getById(Long id) {
        return fabricRepo.findById(id);
    }

//    public Mono<Boolean> update(Position position) {
//        return position.update(position);
//    }

    public Mono<Fabric> addOne(Fabric fabric) {
        return fabricRepo.save(fabric);
    }

    public Mono<Void> delete(Fabric fabric) {
        return fabricRepo.delete(fabric);
    }
}
