package com.mycompany;
import java.util.Random;

public abstract class Employee {
    Random random = new Random();

    private String name;
    private int idEmployee;
    private double salary;

    public abstract double calcSalary();

    public Employee(String name, double salary){
        this.name = name;
        this.idEmployee = random.nextInt(100000) + 1;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
