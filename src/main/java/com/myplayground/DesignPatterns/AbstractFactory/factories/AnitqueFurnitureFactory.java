package com.myplayground.DesignPatterns.AbstractFactory.factories;

import com.myplayground.DesignPatterns.AbstractFactory.AntiqueChair;
import com.myplayground.DesignPatterns.AbstractFactory.AntiqueTable;
import com.myplayground.DesignPatterns.AbstractFactory.Chair;
import com.myplayground.DesignPatterns.AbstractFactory.Table;

public class AnitqueFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new AntiqueChair();
    }

    @Override
    public Table createTable() {
        return new AntiqueTable();
    }
}
