package com.myplayground.DesignPatterns.ChainOfResponsibility;

public class Currency {
    private int amount;

    Currency(int amt) {
        this.amount = amt;
    }

    public int getAmount() {
        return this.amount;
    }
}