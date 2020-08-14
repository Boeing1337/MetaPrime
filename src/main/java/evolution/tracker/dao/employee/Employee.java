package evolution.tracker.dao.employee;

import evolution.tracker.dao.fabric.Fabric;
import evolution.tracker.dao.person.Person;
import evolution.tracker.dao.position.Position;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

/**
 * The {@link Employee} entity of {@link EmployeeRepo} table.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Data
public class Employee {

    /**
     * @value id is a primary INT key
     */
    @Id
    private Long id;

    /**
     * @value person_id is a INT foreign key to {@link Person}.
     * Always required (NOT NULL)
     * Many to one
     */
    @Column("person_id")
    private Long personId;

    /**
     * @value position_code is a INT foreign key to {@link Position}.
     * Always required (NOT NULL)
     * Many to one
     */
    @Column("position_code")
    private Long positionCode;

    /**
     * @value fabric_code is a INT foreign key to {@link Fabric}.
     * Always required (NOT NULL)
     * Many to one
     */
    @Column("fabric_code")
    private Long fabricCode;

    /**
     * @value hiring_date is hiring date of an employee.
     * This Date must be less than @expiration_date
     * Always required (NOT NULL)
     */
    @Column("hiring_date")
    private Date hiringDate;

    /**
     * @value expiration_date is expiration date of an employee.
     * This Date must be bigger than @hiring_date or can be NULL
     * Not required (NULLABLE)
     */
    @Column("expiration_date")
    private Date expirationDate;
}
