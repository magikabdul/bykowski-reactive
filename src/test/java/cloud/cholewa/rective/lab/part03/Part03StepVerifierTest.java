package cloud.cholewa.rective.lab.part03;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Part03StepVerifierTest {

    Part03StepVerifier part = new Part03StepVerifier();

    //Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then completes successfully.
    @Test
    void expectFooBarComplete() {
        StepVerifier.create(part.twoEmittedElements())
                .expectNext("foo")
                .expectNext("bar")
                .verifyComplete();
    }

    //Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then a RuntimeException error.
    @Test
    void expectFooBarError() {
        StepVerifier.create(part.twoEmittedElementsAndError())
                .expectNext("foo")
                .expectNext("bar")
                .expectError(RuntimeException.class)
                .verify();
    }
}
