package com.myplayground.DesignPatterns.ChainOfResponsibility;

import java.util.Scanner;

public class COP_Driver {
    public static void main(String[] args) {
        DispenseChain c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        if (amount % 10 != 0) throw new IllegalArgumentException("Amount has to be multiple of 10.");
        c1.dispense(new Currency(amount));
    }
}
