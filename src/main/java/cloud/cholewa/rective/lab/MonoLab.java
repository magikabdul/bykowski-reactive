package cloud.cholewa.rective.lab;

import reactor.core.publisher.Mono;

class MonoLab {

    //Return an empty Mono
    Mono<String> emptyMono() {
        return Mono.empty();
    }

    //Return a Mono that never emits any signal
    Mono<String> monoWithNoSignal() {
        return Mono.never();
    }
}
