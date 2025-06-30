package com.myplayground.DesignPatterns.ChainOfResponsibility;

public interface DispenseChain {
    public void setNextChain(DispenseChain nextChain);
    public void dispense(Currency currency);
}
