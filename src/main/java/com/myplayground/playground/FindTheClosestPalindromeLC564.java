package com.myplayground.playground;

import com.sun.jdi.CharType;

import java.util.Arrays;

public class FindTheClosestPalindromeLC564 {
    public static void main(String[] args) {
        String s = "123";
        String result = new FindTheClosestPalindromeLC564().find(s);
        System.out.println(result);
    }

    public String find(String s) {
        int len = s.length();
        if (len == 1) {
            return Integer.toString(Integer.parseInt(s) -1);
        }
        long original = Long.parseLong(s);
        long lessDigits = (long) Math.pow(10, len -1) -1;
        long moreDigits = (long) Math.pow(10, len) +1 ;

        long half = Long.parseLong(s.substring(0, (len+1)/2));
        boolean isEven = s.length() %2 == 0;
        long same = buildPalindrome(half, isEven);
        long bigger =  buildPalindrome(half+1, isEven);
        long smaller =  buildPalindrome(half-1, isEven);

        long[] candidates = {same, bigger, smaller, lessDigits, moreDigits};
        Arrays.sort(candidates);

        long closest =  Long.MAX_VALUE;
        for (long candidate : candidates) {
            if (candidate == original) continue;
            long difference = Math.abs(candidate - original);
            long can = Math.abs(closest - original);
            if (difference < can) {
                closest = candidate;
            }
        }
LC
        return Long.toString(closest);
    }

    public long buildPalindrome(long number, boolean isEven) {
        String halfStr = Long.toString(number);
        if (isEven) {
            halfStr = halfStr + new StringBuilder(halfStr).reverse();
        } else {
            halfStr = halfStr + new StringBuilder(halfStr.substring(0, halfStr.length()-1)).reverse();
        }
        return Long.parseLong(halfStr);
    }
}
