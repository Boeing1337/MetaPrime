package evolution.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Reactive REST API application for CRUD operations.
 */
@SpringBootApplication
public class TrackerApplication {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(TrackerApplication.class, args);
    }

}
