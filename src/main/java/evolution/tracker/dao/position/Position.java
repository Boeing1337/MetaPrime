package evolution.tracker.dao.position;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Position {
    @Id
    private Long id;
    private Long code;
    private String type;
    private String factor;
    private Long salary;
}
