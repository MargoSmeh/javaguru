package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkProductNotNull(product);
        if (product.getName().length() < 3 || product.getName().length() > 33) {
            throw new ProductValidationException("Name should be from 3 to 32 symbols");
        }
    }
}
