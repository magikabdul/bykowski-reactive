package cloud.cholewa.rective.lab;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;

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

    @Test
    void shouldReturnFluxThatEmitsTwoStringValuesFromList() {
        StepVerifier.create(fluxLab.fooBarFluxFromList())
                .expectSubscription()
                .expectNext("foo")
                .expectNext("bar")
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void shouldReturnErrorTypeIllegalStateException() {
        StepVerifier.create(fluxLab.errorFlux())
                .expectError(IllegalStateException.class)
                .verify();
    }

    @Test
    void shouldEmitsTenValuesInPace100ms() {
        StepVerifier.create(fluxLab.counter())
                .recordWith(ArrayList::new)
                .thenConsumeWhile(a -> true, System.out::println)
                .expectNextCount(0)
                .expectRecordedMatches(longs -> longs.size() == 10)
                .verifyComplete();
    }
}
