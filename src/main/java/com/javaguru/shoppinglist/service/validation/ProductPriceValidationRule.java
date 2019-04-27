package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkProductNotNull(product);
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price cannot be 0 or less");
        }
    }
}
