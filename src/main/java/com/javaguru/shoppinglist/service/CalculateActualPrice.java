package com.javaguru.shoppinglist.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculateActualPrice {


    public BigDecimal calculateDiscount(BigDecimal price, BigDecimal discount) {
        return price.multiply(discount).divide(new BigDecimal(100), 2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal calculateActualPrice(BigDecimal price, BigDecimal discount) {
        return price.subtract(calculateDiscount(price,discount));
    }
}
