package cloud.cholewa.rective.lab;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

class FluxLab {

    //Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

    //Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

    //Create a Flux from a List that contains 2 values "foo" and "bar"
    Flux<String> fooBarFluxFromList() {
        List<String> stringList = List.of("foo", "bar");

        return Flux.fromIterable(stringList);
    }

    //Create a Flux that emits an IllegalStateException
    Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException());
    }

    //Create a Flux that emits increasing values from 0 to 9 each 100ms
    Flux<Long> counter() {
        return Flux.interval(Duration.ofMillis(100)).take(10);
    }
}
