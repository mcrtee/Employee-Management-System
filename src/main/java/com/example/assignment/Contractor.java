package com.example.assignment10;

public class Contractor extends Employee {
    private double hourlyRate;
    private int maxHours;

    public Contractor(String name, double hourlyRate, int maxHours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * maxHours;
    }
}
