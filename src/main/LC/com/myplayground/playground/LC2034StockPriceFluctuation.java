package com.myplayground.playground;

import java.util.HashMap;
import java.util.TreeMap;

public class LC2034StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice obj = new StockPrice();
        obj.update(1,10);
        obj.update(2,5);
        System.out.println(obj.current());
        System.out.println(obj.maximum());
        obj.update(1, 3);
        System.out.println(obj.maximum());
        obj.update(4,2);
        System.out.println(obj.minimum());

    }

}

class StockPrice {
    HashMap<Integer, Integer> stock = new HashMap<>();
    int maxPrice = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;
    int latestTime =  -1;
    TreeMap<Integer, Integer> prices = new TreeMap<>();
    public StockPrice() {

    }

    public void update(int timestamp, int price) {

        latestTime = Math.max(latestTime, timestamp);

        if (stock.containsKey(timestamp)) {
            int oldprice = stock.get(timestamp);
            stock.remove(timestamp);
            prices.put(oldprice, prices.get(oldprice)-1);
            if (prices.get(oldprice) == 0) {
                prices.remove(oldprice);
            }
        }

        stock.put(timestamp, price);
        prices.put(price, prices.getOrDefault(price, 0)+1);
    }

    public int current() {
        return stock.get(latestTime);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */