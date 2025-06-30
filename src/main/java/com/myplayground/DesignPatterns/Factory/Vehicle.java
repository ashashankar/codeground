package com.myplayground.DesignPatterns.Factory;

public abstract class Vehicle {
    public void print(String model, String year) {
        System.out.println(" Vehicle model and year "+ model + " " + year);
    }

    public abstract int rangeInKms();
}
