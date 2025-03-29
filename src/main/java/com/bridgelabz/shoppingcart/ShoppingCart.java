package com.bridgelabz.shoppingcart;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Product -> Price
    private Map<String, Integer> cartItems = new LinkedHashMap<>(); // Maintain order of added items
    private TreeMap<Double, String> sortedByPrice = new TreeMap<>(); // Sorted by price

    // Add product to the store
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add product to the cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            sortedByPrice.put(productPrices.get(product), product);
            System.out.println(" Added " + quantity + " x " + product + " to the cart.");
        } else {
            System.out.println(" Product not found! Please add it to the store first.");
        }
    }

    // Display cart items
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("\n Your cart is empty!");
            return;
        }

        System.out.println("\n Items in your cart:");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " units");
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        if (sortedByPrice.isEmpty()) {
            System.out.println("\n No items in the cart to display by price.");
            return;
        }

        System.out.println("\nItems sorted by price:");
        for (Map.Entry<Double, String> entry : sortedByPrice.entrySet()) {
            System.out.println(entry.getValue() + " -> $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to the Shopping Cart System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 Add a product to the store");
            System.out.println("2 Add product to cart");
            System.out.println("3 View cart");
            System.out.println("4 View items sorted by price");
            System.out.println("5 Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println(" Invalid input! Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String product = scanner.nextLine().trim();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    cart.addProduct(product, price);
                    System.out.println(" Product added: " + product + " - $" + price);
                    break;

                case 2:
                    System.out.print("Enter product name: ");
                    String cartProduct = scanner.nextLine().trim();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    cart.addToCart(cartProduct, quantity);
                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:
                    cart.displaySortedByPrice();
                    break;

                case 5:
                    System.out.println(" Exiting the Shopping Cart System. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
