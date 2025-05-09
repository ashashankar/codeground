package com.myplayground.playground;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5,5,5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int total = 0;
        int fives = 0;
        int tens = 0;
        int twentys = 0;

        for (int i: bills) {
            if (i == 5) {
                fives++;
                total += 5;
            } else if (i == 10) {
                int give = 5;
                total += 5;
                tens++;
                if (fives < 1) return false;
                fives -= 1;
            } else {
                int give = 15;
                total += 5;
                twentys++;
                int n = give /5;
                if (tens >=1 && fives >= 1) {
                    fives--;
                    tens--;
                    continue;
                } else if (fives >= n){
                    fives -= n;
                } else if (fives != n) {
                    return false;
                }
            }

        }
        return true;
    }
}
