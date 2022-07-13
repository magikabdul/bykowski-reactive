package cloud.cholewa.rective.lab;

import reactor.core.publisher.Flux;

class FluxLab {

    Flux<String> emptyFlux() {
        return Flux.empty();
    }
}
