package com.mycompany.miniproject;

import java.util.Scanner;

public class MiniProject {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        shoppingCart cart = new shoppingCart(10);
        String[] predefinedItems = {"Apple", "Banana", "Carrot"};
        double[] predefinedPrices = {0.99, 0.59, 0.39};

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Check Total");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Would you like to add a predefined item (yes/no)?");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("yes")) {
                        for (int i = 0; i < predefinedItems.length; i++) {
                            System.out.println((i + 1) + ". " + predefinedItems[i] + " - $" + predefinedPrices[i]);
                        }
                        System.out.print("Select an item to add: ");
                        int item = Integer.parseInt(scanner.nextLine());
                        if (item > 0 && item <= predefinedItems.length) {
                            cart.addProduct(predefinedItems[item - 1], predefinedPrices[item - 1]);
                        } else {
                            System.out.println("Invalid item selected.");
                        }
                    } else {
                        System.out.println("Enter the name of the product:");
                        String name = scanner.nextLine();
                        System.out.println("Enter the price of the product:");
                        double price = Double.parseDouble(scanner.nextLine());
                        cart.addProduct(name, price);
                    }
                    break;
                case "2":
                    cart.printCart();
                    System.out.print("Enter item number to remove: ");
                    int itemNumber = Integer.parseInt(scanner.nextLine());
                    cart.removeProduct(itemNumber);
                    break;
                case "3":
                    cart.printCart();
                    break;
                case "4":
                    System.out.println("Total price: $" + cart.checkTotal());
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
    

