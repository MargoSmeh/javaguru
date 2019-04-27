package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private ProductInMemoryRepository database;
    private ProductValidationService validationService;

    @Autowired
    public ProductService(ProductInMemoryRepository database, ProductValidationService validationService) {
        this.database = database;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = database.addProduct(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return database.findById(id);
    }
}
