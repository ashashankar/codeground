package com.myplayground.DesignPatterns.AbstractFactory;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Modern chair modern decor ");
    }
}
