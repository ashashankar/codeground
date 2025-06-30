package com.myplayground.DesignPatterns.AbstractFactory;

public class AntiqueTable implements Table {
    @Override
    public void placeOn() {
        System.out.println("Antique table classic outlook ");
    }
}
