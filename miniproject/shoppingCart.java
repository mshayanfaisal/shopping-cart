package com.mycompany.miniproject;

import java.util.Scanner;

public class shoppingCart {
    private String[] cart;
    private double[] prices;
    private int[] quantities;
    private int itemCount;
    
    public shoppingCart(int size) {
        this.cart = new String[size];
        this.prices = new double[size];
        this.quantities = new int[size];
        this.itemCount = 0;
    }
  
    public void addProduct(String name, double price) {
        for (int i = 0; i < itemCount; i++) {
            if (cart[i].equals(name)) {
                quantities[i]++;
                return;
            }
        }
        if (itemCount < cart.length) {
            cart[itemCount] = name;
            prices[itemCount] = price;
            quantities[itemCount] = 1;
            itemCount++;
        } else {
            System.out.println("Cart is full.");
        }
    }
    
    public void removeProduct(int itemNumber) {
        if (itemNumber >= 1 && itemNumber <= itemCount) {
            for (int i = itemNumber - 1; i < itemCount - 1; i++) {
                cart[i] = cart[i + 1];
                prices[i] = prices[i + 1];
                quantities[i] = quantities[i + 1];
            }
            itemCount--;
        } else {
            System.out.println("Invalid item number.");
        }
    }
    
    public void printCart() {
        double total = 0.0;
        System.out.println("Cart contents:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + cart[i] + " - $" + prices[i] + " x " + quantities[i]);
            total += prices[i] * quantities[i];
        }
        System.out.println("Total: $" + total);
    }
    
    public double checkTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i] * quantities[i];
        }
        return total;
    }
}
