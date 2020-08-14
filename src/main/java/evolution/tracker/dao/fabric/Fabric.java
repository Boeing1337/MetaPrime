package evolution.tracker.dao.fabric;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 * The {@link Fabric} entity of {@link FabricRepo} table.
 *
 * @author Dmitry Morozov
 * 08.2020
 * @version 0.1
 */
@Data
@NoArgsConstructor
public class Fabric {
    /**
     * @value id is a unique INT
     */
    @Id
    private Long id;

    /**
     * @value code is a unique INT represents fabrics' code
     * Always required (NOT NULL)
     */
    @Column("code")
    private Long code;

    /**
     * @value type is a unique VARCHAR represents fabrics' type
     * Always required (NOT NULL)
     */
    @Column("type")
    private String type;
}
