package com.mycompany;

public class Order {
    private Product[] products;
    private double price;
    private int idCustomer;
    private boolean isPayed;

    public Order(Product[] products, int id) {
        this.products = products;
        this.price = calculateTotalPrice();
        this.idCustomer = id; // El ID del cliente se establecerá posteriormente
        this.isPayed = false;
    }
    public Product[] getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}