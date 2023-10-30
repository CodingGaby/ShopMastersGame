package com.mycompany;

import java.util.ArrayList;

public class Shop {
    private String name;
    private String owner;
    private ArrayList<Product> products;
    private ArrayList<Employee> employees;

    public Shop(String name, Player owner){
        this.name = name;
        this.owner = owner.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner.getName();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public double calcTotalSalary(){
        double totalSalary = 0;
        for (int i = 0; i < employees.size(); i++){
            totalSalary += employees.get(i).calcSalary();
        }

        return totalSalary;
    }
}
