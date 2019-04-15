package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    private ProductService productService = new ProductService();

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create Product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findById();
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    public void createProduct() {
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
            Long response = productService.createProduct(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        Product response = productService.findProductById(id);
        System.out.println("Response: " + response);
    }
}