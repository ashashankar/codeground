package com.myplayground.playground;

import java.util.HashSet;

public class NumberOfWaysToSelectABuilderLC2222 {

    public static void main(String[] args) {
        String s = "11100";//"110010";
        long count  = new NumberOfWaysToSelectABuilderLC2222().numberOfWays(s);
        System.out.println(count);
    }
    public long numberOfWays(String s) {
        int len = s.length();
        int[] pf0 = new int[len];
        int[] pf1 = new int[len];
        if (s.charAt(0) == '0') {
            pf0[0]++ ;
        } else {
            pf1[0]++;
        }

        for (int i=1; i<len; i++) {
            pf0[i] = pf0[i-1];
            pf1[i] = pf1[i-1];
            if(s.charAt(i) == '0') {
                pf0[i]++;
            } else {
                pf1[i]++;
            }
        }
        long total = 0;
        for (int i=1; i<len-1; i++) {
            if (s.charAt(i) == '0') {
                long left1 = pf1[i-1];
                long right1 = pf1[len-1] - pf1[i];
                total += left1 * right1;
            } else {
                long left0 = pf0[i-1];
                long right0 = pf0[len-1] - pf0[i];
                total += left0 * right0;
            }

        }
        return total;
    }
}
