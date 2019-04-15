package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    private final ProductValidationService productValidationService;

    public CreateProductAction(ProductService productService, ProductValidationService productValidationService) {
        this.productService = productService;
        this.productValidationService = productValidationService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        System.out.println("Enter discount: ");
        String discount = scanner.nextLine();


        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));
        System.out.println("Actual price: " + product.calculateActualPrice());

        try {
            productValidationService.validateName(product);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            productValidationService.validatePrice(product);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            productValidationService.validateDiscount(product);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
