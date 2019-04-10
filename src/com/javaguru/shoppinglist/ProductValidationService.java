package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidationService {

    public void validateName(Product product) throws ValidationException {
        if (product.getName().length() < 3 || product.getName().length() > 33) {
            throw new ValidationException();
        }
    }

    public void validatePrice(Product product) throws ValidationException {
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException();
        }
    }

    public void validateDiscount(Product product) throws ValidationException {
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) >= 0) {
            throw new ValidationException();
        }
    }

}



