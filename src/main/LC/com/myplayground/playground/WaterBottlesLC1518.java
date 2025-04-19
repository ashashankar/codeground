package com.myplayground.playground;

public class WaterBottlesLC1518 {

    public static void main(String[] args) {
        int consumed = numWaterBottles(15, 4);
        System.out.println(consumed);
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;

        while (numBottles >= numExchange) {
            int full = numBottles / numExchange;
            int empty = numBottles%numExchange;
            total += full;
            numBottles = full + empty;
        }

        return total;
    }
}
