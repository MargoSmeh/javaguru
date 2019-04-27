package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductInMemoryRepository {

    private Map<Long, Product> database = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product addProduct(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findById(Long id) {
        return database.get(id);
    }
}
