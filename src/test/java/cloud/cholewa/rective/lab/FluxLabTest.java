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
}
