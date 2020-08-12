package evolution.tracker.dao.person;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date date_of_birth;
}
