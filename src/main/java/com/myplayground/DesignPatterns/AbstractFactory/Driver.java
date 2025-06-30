package com.myplayground.DesignPatterns.AbstractFactory;

import com.myplayground.DesignPatterns.AbstractFactory.factories.AnitqueFurnitureFactory;
import com.myplayground.DesignPatterns.AbstractFactory.factories.FurnitureFactory;
import com.myplayground.DesignPatterns.AbstractFactory.factories.ModernFurnitureFactory;

public class Driver {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new ModernFurnitureFactory();
        Chair chair = furnitureFactory.createChair();
        chair.sitOn();
        Table table = furnitureFactory.createTable();
        table.placeOn();

        furnitureFactory = new AnitqueFurnitureFactory();
        chair = furnitureFactory.createChair();
        chair.sitOn();
        table = furnitureFactory.createTable();
        table.placeOn();
    }
}
