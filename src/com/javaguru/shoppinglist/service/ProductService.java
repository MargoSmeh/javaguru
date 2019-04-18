package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private ProductInMemoryRepository database = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = database.addProduct(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return database.findById(id);
    }
}
