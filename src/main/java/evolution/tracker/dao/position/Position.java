package evolution.tracker.dao.position;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Position {
    @Id
    private Long code;
    private String type;
    private Long factor;
    private Long salary;
}
