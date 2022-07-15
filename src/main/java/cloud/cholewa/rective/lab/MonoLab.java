package cloud.cholewa.rective.lab;

import reactor.core.publisher.Mono;

class MonoLab {

    //Return an empty Mono
    Mono<String> emptyMono() {
        return Mono.empty();
    }
}
