package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

    default void checkProductNotNull(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
    }
}
