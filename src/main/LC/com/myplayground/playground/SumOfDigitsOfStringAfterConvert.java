package com.myplayground.playground;

import java.util.Arrays;

public class SumOfDigitsOfStringAfterConvert {
    public static void main(String[] args) {
        new SumOfDigitsOfStringAfterConvert().convert("zbax", 2);
    }

    public int convert(String s, int k) {
        int result = 0;
        int[] chars = new int[26];
        for (int i=0; i<chars.length; i++) {
            chars[i] = i + 'a';
        }

        int sum = 0;
        StringBuilder sb  = new StringBuilder();
        for (char a: s.toCharArray()) {
            int val = chars[a - 'a'] - 'a' + 1;
            sb.append(val);
        }

        while ( k > 0) {
            for (int i=0; i<sb.length(); i++) {
                sum += Character.getNumericValue(sb.charAt(i));
            }
            sb.replace(0, sb.length(), sum+"");
            sum = 0;
            k--;
        }
        result = Integer.parseInt(sb.toString());
        return result;
    }
}
