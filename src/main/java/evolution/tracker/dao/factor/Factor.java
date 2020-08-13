package evolution.tracker.dao.factor;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Factor {

    @Id
    private Long id;
    private String type;
    private Long salaryBonus;
    private Long vacationBonus;
}
