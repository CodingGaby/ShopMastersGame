package com.mycompany;

import java.util.Scanner;

public class EmployeeFull extends Employee{
    Scanner inp = new Scanner(System.in);

    public EmployeeFull(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calcSalary(){
        return getSalary();
    }
}
