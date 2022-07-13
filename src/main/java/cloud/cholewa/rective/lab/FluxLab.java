package cloud.cholewa.rective.lab;

import reactor.core.publisher.Flux;

class FluxLab {

    //Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

    //Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }
}
