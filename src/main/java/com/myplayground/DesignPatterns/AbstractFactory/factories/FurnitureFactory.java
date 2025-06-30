package com.myplayground.DesignPatterns.AbstractFactory.factories;

import com.myplayground.DesignPatterns.AbstractFactory.Chair;
import com.myplayground.DesignPatterns.AbstractFactory.Table;

public interface FurnitureFactory {
    public Chair createChair();
    public Table createTable();
}
