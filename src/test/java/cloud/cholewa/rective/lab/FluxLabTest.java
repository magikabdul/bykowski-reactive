package cloud.cholewa.rective.lab;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxLabTest {

    private final FluxLab fluxLab = new FluxLab();

    @Test
    void shouldReturnEmptyStream() {
        StepVerifier.create(fluxLab.emptyFlux())
                .expectSubscription()
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void shouldReturnFluxThatEmitsTwoStringValues() {
        StepVerifier.create(fluxLab.fooBarFluxFromValues())
                .expectSubscription()
                .expectNext("foo")
                .expectNext("bar")
                .expectNextCount(0)
                .verifyComplete();
    }


}
