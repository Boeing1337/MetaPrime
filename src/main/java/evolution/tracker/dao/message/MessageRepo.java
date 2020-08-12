package evolution.tracker.dao.message;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends ReactiveCrudRepository<Message, Long> {

}
