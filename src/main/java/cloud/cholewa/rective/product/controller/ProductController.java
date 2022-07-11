package cloud.cholewa.rective.product.controller;

import cloud.cholewa.rective.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("works");
    }
}
