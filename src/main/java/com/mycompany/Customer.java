package com.mycompany;
import java.util.ArrayList;
import java.util.Random;

public class Customer {
    Random random = new Random();

    //atributos
    private int idCustomer;
    private Order order;

    //Constructor
    public Customer(){
        this.idCustomer = random.nextInt(100000) + 1;
        this.order = null;
    }

    //metodos
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product[] chooseProduct(ArrayList<Product> products) {

        int numberOfProducts = random.nextInt(4) + 1; // Selecciona de 1 a 3 cafés aleatorios

        Product[] selectedProducts = new Product[numberOfProducts];

        for (int i = 0; i < numberOfProducts; i++) {
            int randomIndex = random.nextInt(products.size());
            selectedProducts[i] = products.get(randomIndex);
        }

        return selectedProducts;
    }

    public void askProduct(ArrayList<Product> products) {
        Order ord = new Order(chooseProduct(products), this.getIdCustomer());

        this.setOrder(ord);
        System.out.println("Voy a querer:");

        for (Product product : order.getProducts()) {
            System.out.println("\u001B[0m-\u001B[34m" + product.getName() + "\u001B[0m");
        }
    }

}