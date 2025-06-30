package com.myplayground.DesignPatterns.Factory;

public class Car extends Vehicle{

    int weight;
    Car(String make, String year, int weight) {
        super.print(make, year);
        this.weight = weight;
    }


    @Override
    public int rangeInKms() {
        return (weight * 6);
    }
}
