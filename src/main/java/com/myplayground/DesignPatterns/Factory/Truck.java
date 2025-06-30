package com.myplayground.DesignPatterns.Factory;

public class Truck extends Vehicle{

    int weight;
    Truck(String make, String year, int weight) {
        super.print(make, year);
        this.weight = weight;
    }


    @Override
    public int rangeInKms() {
        return (weight > 100)? 300 : 200;
    }
}
