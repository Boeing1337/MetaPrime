package evolution.tracker.dao.fabric;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Fabric {
    @Id
    private Long id;
    private Long code;
    private String type;
}
