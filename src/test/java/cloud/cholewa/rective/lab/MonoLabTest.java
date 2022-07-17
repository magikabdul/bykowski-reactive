package cloud.cholewa.rective.lab;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

class MonoLabTest {

    private final MonoLab monoLab = new MonoLab();

    @Test
    void shouldReturnEmptyMono() {
        StepVerifier.create(monoLab.emptyMono())
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void shouldNoEvenEmitOnComplete() {
        StepVerifier.create(monoLab.monoWithNoSignal())
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(2))
                .thenCancel()
                .verify();
    }

    @Test
    void shouldEmitMonoWithSingleValue() {
        StepVerifier.create(monoLab.fooMono())
                .expectNext("foo")
                .verifyComplete();
    }
}
