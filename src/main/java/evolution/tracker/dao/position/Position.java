package evolution.tracker.dao.position;

import evolution.tracker.dao.factor.Factor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 * The {@link Position} entity of {@link PositionRepo} table.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Data
public class Position {
    /**
     * @value id is a unique INT
     */
    @Id
    private Long id;

    /**
     * @value code is a unique INT represents position' code
     * Always required (NOT NULL)
     */
    @Column("code")
    private Long code;

    /**
     * @value type is a unique VARCHAR represents type of a position
     * Always required (NOT NULL)
     */
    @Column("type")
    private String type;

    /**
     * @value factor is a VARCHAR foreign key to {@link Factor}.
     * Always required (NOT NULL)
     * Many to one
     */
    @Column("factor")
    private String factor;

    /**
     * @value salary is a unique VARCHAR represents salary of a position
     * Always required (NOT NULL)
     * The amount must be more that 15000
     */
    @Column("salary")
    private Long salary;
}
