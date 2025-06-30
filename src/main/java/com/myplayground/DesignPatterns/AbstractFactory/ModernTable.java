package com.myplayground.DesignPatterns.AbstractFactory;

public class ModernTable implements Table {
    @Override
    public void placeOn() {
        System.out.println("Modern table modern outlook ");
    }
}
