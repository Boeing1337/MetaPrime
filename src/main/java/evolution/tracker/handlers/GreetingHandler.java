package evolution.tracker.handlers;

import evolution.tracker.dao.message.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * The type Greeting handler.
 */
@Component
public class GreetingHandler {
    /**
     * Hello mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> hello(final ServerRequest request) {
        Long start = request.queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);
        Long count = request.queryParam("count")
                .map(Long::valueOf)
                .orElse(3L);
        Flux<Message> data = Flux.just(
                "Hello reactive",
                "More that one",
                "third post",
                "fourth post",
                "fifth post"
        )
                .skip(start)
                .take(count)
                .map(e -> new Message(1L, e));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Message.class);
    }

    /**
     * Index mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> index(final ServerRequest request) {
        String user = request.queryParam("user")
                .orElse("Nobody");
        return ServerResponse
                .ok()
                .render("index", Map.of("user", user));

    }
}
