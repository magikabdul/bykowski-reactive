package cloud.cholewa.rective.product.service;

import cloud.cholewa.rective.product.model.Product;
import cloud.cholewa.rective.product.repository.ProductRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final Faker faker = new Faker();

    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initBase() {
        for (int i = 0; i < 9; i++) {
            var product = Product.builder()
                    .id(UUID.randomUUID())
                    .name(faker.funnyName().name())
                    .build();
            repository.save(product);
        }
    }
}
