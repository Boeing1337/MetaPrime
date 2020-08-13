package evolution.tracker.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;


/**
 * The type Greeting router.
 */
@Configuration
public class GreetingRouter {
    /**
     * Route router function.
     *
     * @param greetingHandler the greeting handler
     * @return the router function
     */
    @Bean
    public RouterFunction<ServerResponse> route(
            final GreetingHandler greetingHandler) {

        RequestPredicate hello = RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN));
        RequestPredicate root = RequestPredicates.GET("/");

        return RouterFunctions
                .route(hello, greetingHandler::hello)
                .andRoute(root, greetingHandler::index);

    }
}
