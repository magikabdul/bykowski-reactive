package cloud.cholewa.rective.product.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class Product {

    private UUID id;
    private String name;
}
