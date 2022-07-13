package cloud.cholewa.rective.lab;

import reactor.core.publisher.Flux;

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
}
