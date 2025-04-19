package com.myplayground.playground;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * there are K machines . Each machine has a stock prices array. Calculate the aggregated profit.
 * Machine 1 - {2, 4, 8, 10} - profit 8
 * Machine 2 - {3, 20} - profit 17
 * When combined  = aggregated profit is  20 - 2 = 18
 *
 * Ex2:
 * Machine 1 - {2, 4, 8, 10} - profit 8
 * Machine 2 - {13, 1} - profit -12
 * When combined  = aggregated profit is  8
 */
public class ZooxMaximizeProfitInDistributedEnviornment {
    public static void main(String[] args) {
        int[] m1 = {1, 7, 10, 8, 5, 3, 2, 5, 11, 17};
        int[] m2 = {6, 11, 12, 8, 5, 7, 10, 13, 20};
        ArrayList<machine> machines = new ArrayList<>();
        machines.add(calculateProfitForEachMachine(m1, 1));
        machines.add(calculateProfitForEachMachine(m2, 2));
        machines.sort(Comparator.comparingInt(machine::getMachine));
        ArrayList<Integer> prices = new ArrayList<>();
        for (machine m : machines) {
            prices.add(m.buyerPrice);
            prices.add(m.sellingPrice);
        }
        Integer[] input = prices.toArray(new Integer[prices.size()]);
        System.out.println(calculateProfit(input));
    }


    public static int calculateProfit(Integer[] prices) {
        int buyerPrice = prices[0];
        int profit = 0;

        for (int i=0; i<prices.length; i++) {
            if (buyerPrice > prices[i]) {
                buyerPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyerPrice);
        }
        return profit;
    }

    public static machine calculateProfitForEachMachine(int[] prices, int m) {
        int buyerPrice = prices[0];
        int profit = 0;
        int sp = 0;
        int b = 0;
        for (int i=1; i<prices.length; i++) {
            sp = Math.max(sp, prices[i]);
            if (prices[i] < buyerPrice) {
                buyerPrice = prices[i];
            }
            //profit = Math.max(profit, prices[i] - buyerPrice);
            int p = prices[i] - buyerPrice;
            if (p > profit) {
                b = buyerPrice;
                sp = prices[i];
                profit = p;
            }
        }
        System.out.println("selling prices " + sp + " buy " + b + " profit " + profit);
        return new machine(m, b, sp, profit);
    }

}

@Getter
class machine {
    int machine;
    int buyerPrice;
    int sellingPrice;
    int profit;
    machine(int m, int b, int s, int profit) {
        this.machine = m;
        this.buyerPrice = b;
        this.sellingPrice = s;
        this.profit = profit;
    }

}