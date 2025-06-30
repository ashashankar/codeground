package com.myplayground.DesignPatterns.AbstractFactory.factories;

import com.myplayground.DesignPatterns.AbstractFactory.*;

public class ModernFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
