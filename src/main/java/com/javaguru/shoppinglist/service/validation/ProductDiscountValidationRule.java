package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkProductNotNull(product);
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) >= 0) {
            throw new ProductValidationException("Discount should be less than 100%");
        }
    }
}
