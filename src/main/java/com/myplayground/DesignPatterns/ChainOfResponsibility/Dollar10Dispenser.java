package com.myplayground.DesignPatterns.ChainOfResponsibility;

public class Dollar10Dispenser  implements DispenseChain {
    DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 10) {
            int nos = currency.getAmount()/10;
            int remainder = currency.getAmount()%10;
            System.out.println("Dispensing "+ nos + " count $10 note");
            if (remainder != 0) this.nextChain.dispense(new Currency(remainder));
        } else {
            this.nextChain.dispense(currency);
        }
    }
}
