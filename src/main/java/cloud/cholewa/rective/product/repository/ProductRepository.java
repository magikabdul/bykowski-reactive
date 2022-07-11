package cloud.cholewa.rective.product.repository;

import cloud.cholewa.rective.product.model.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    List<Product> findAll();
}
