package cloud.cholewa.rective.lab.part03;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class Part03StepVerifier {

    Flux<String> twoEmittedElements() {
        return Flux.just("foo", "bar");
    }

    Flux<String> twoEmittedElementsAndError() {
        return Flux.generate(() -> "foo", (state, sink) -> {
            String value = state;
            sink.next(value);

            if (value.equals("foo")) {
                value = "bar";
            } else {
                sink.error(new RuntimeException());
            }
            return value;
        });
    }
}
