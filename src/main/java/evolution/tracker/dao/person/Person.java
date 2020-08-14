package evolution.tracker.dao.person;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

/**
 * The {@link Person} entity of {@link PersonRepo} table.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Data
public class Person {

    /**
     * @value id is a primary INT key
     */
    @Id
    private Long id;

    /**
     * @value first_name is a VARCHAR of first name.
     * Always required (NOT NULL)
     */
    @Column("first_name")
    private String firstName;

    /**
     * @value last_name is a VARCHAR of last name.
     * Always required (NOT NULL)
     */
    @Column("last_name")
    private String lastName;

    /**
     * @value gender is a VARCHAR of gender.
     * Always required (NOT NULL)
     */
    @Column("gender")
    private String gender;

    /**
     * @value email is a VARCHAR of email.
     * Not required (NULLABLE)
     */
    @Column("email")
    private String email;

    /**
     * @value date_of_birth is a DATE of a birthday.
     * Always required (NOT NULL)
     */
    @Column("date_of_birth")
    private Date dateOfBirth;

    /**
     * @value country_of_birth is a VARCHAR of country of birth.
     * Always required (NOT NULL)
     */
    @Column("country_of_birth")
    private String countryOfBirth;
}
