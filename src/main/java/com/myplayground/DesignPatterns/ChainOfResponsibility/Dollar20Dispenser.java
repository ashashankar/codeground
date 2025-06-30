package com.myplayground.DesignPatterns.ChainOfResponsibility;

public class Dollar20Dispenser implements DispenseChain{
    DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount()>=20) {
            int nos = currency.getAmount()/20;
            int rem = currency.getAmount()%20;
            System.out.println("Dispensing "+ nos + " count $20 note");
            if (rem != 0) this.nextChain.dispense(new Currency(rem));
        } else {
            this.nextChain.dispense(currency);
        }
    }
}
