package cloud.cholewa.rective.lab;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MonoLabTest {

    private final MonoLab monoLab = new MonoLab();

    @Test
    void shouldReturnEmptyMono() {
        StepVerifier.create(monoLab.emptyMono())
                .expectNextCount(0)
                .verifyComplete();
    }
}
