package evolution.tracker.dao.employee;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
public class Employee {

    @Id
    private Long id;
    private Long personId;
    private Long positionCode;
    private Long fabricCode;
    private Date hiringDate;
    private Date expirationDate;
}
