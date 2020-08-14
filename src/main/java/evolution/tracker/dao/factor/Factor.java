package evolution.tracker.dao.factor;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 * The {@link Factor} entity of {@link FactorRepo} table.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Data
public class Factor {

    /**
     * @value id is a unique INT
     */
    @Id
    private Long id;

    /**
     * @value type is a unique VARCHAR represents factor' type
     * Always required (NOT NULL)
     */
    @Column("type")
    private String type;

    /**
     * @value salaryBonus represents additional salary amount
     * The amount must be >= 0 or null
     * Not required (NULLABLE)
     */
    @Column("salary_bonus")
    private Long salaryBonus;

    /**
     * @value vacationBonus represents additional amount of vacation days
     * The amount must be >= 0 or null
     * Not required (NULLABLE)
     */
    @Column("vacation_bonus")
    private Long vacationBonus;
}
