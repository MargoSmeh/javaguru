package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidationService {

    public void validateName(Product product) throws ValidationException {
        if (product.getName().length() < 3 || product.getName().length() > 33) {
            throw new ValidationException("Name should be from 3 to 32 symbols");
        }
    }

    public void validatePrice(Product product) throws ValidationException {
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Price cannot be 0");
        }
    }

    public void validateDiscount(Product product) throws ValidationException {
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) >= 0) {
            throw new ValidationException("Discount should be less than 100%");
        }
    }
}