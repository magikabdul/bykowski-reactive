package cloud.cholewa.rective.product.controller;

import cloud.cholewa.rective.product.model.Product;
import cloud.cholewa.rective.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
class ProductController {

    private final ProductService service;

    @GetMapping("single-list")
    public ResponseEntity<Mono<List<Product>>> getAll() {
        Mono<List<Product>> productMono = Mono.justOrEmpty(service.getAll())
                .delayElement(Duration.ofSeconds(10));
        return ResponseEntity.ok(productMono);
    }

    @GetMapping(value = "stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public ResponseEntity<Flux<Product>> getAllLikeFlux() {
        var productFLux = Flux.fromIterable(service.getAll())
                .delayElements(Duration.ofSeconds(5));

        Flux.fromIterable(List.of("foo", "ba"));
        return ResponseEntity.ok(productFLux);
    }
}
