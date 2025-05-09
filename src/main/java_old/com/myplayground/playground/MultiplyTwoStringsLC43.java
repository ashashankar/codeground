package com.myplayground.playground;

import java.math.BigInteger;
import java.util.ArrayList;

public class MultiplyTwoStringsLC43 {

    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "456";
        System.out.println(multiplyApproach2(num1, num2));
    }

    public static String multiplyApproach2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;

        int[] result = new int[num1.length() + num2.length()];
        char base = '0';
        for (int i= num1.length() -1; i>=0 ; i--) {
            for (int j= num2.length()-1; j>=0; j--) {
                int product = (num1.charAt(i) -base )* (num2.charAt(j) - base);
                product += result[i+j+1];
                result[i+j+1] = product % 10;
                result [i +j] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (sb.isEmpty() && r == 0) {
                continue;
            }
            sb.append(r);
        }
        return sb.toString();
    }

    public static String multiplyApproach1(String num1, String num2) {
        long n1 = 0;
        long len1 = num1.length();
        int base = '0';
        for (int i=0; i<len1; i++) {
            n1 = n1 * 10 + num1.charAt(i) - base;
        }
        long n2 = 0;
        long len2 = num2.length();
        for (int j=0; j<len2; j++) {
            n2 = n2 * 10 + num2.charAt(j) - base;
        }
        long x = n1 * n2;
        return String.valueOf(x);
    }
}
