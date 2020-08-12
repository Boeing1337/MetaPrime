package evolution.tracker.dao.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Message {

    @Id
    private Long id;
    private String data;

}
