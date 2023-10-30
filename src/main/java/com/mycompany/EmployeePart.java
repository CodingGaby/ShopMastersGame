package com.mycompany;

public class EmployeePart extends Employee{
    private int workedHours;

    public EmployeePart(String name, double salary){
        super(name, salary);
    }

    @Override
    public double calcSalary(){
        return getSalary() * workedHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }
}

