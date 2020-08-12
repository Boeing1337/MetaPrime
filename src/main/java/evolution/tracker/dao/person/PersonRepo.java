package evolution.tracker.dao.person;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepo extends ReactiveCrudRepository<Person, Long> {
    Flux<Person> findAllByFirstNameAndLastName(String firstName, String lastName);
    Mono<Person> findByEmail(String email);
}
