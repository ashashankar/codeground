package com.myplayground.DesignPatterns.Factory;

public class Driver_Factory {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "2002", 100);
        System.out.println(car.rangeInKms());
        Vehicle truck = new Truck("Ford", "2012" , 1000);
        System.out.println(truck.rangeInKms());
    }
}
