package com.myplayground.playground;

public class MinimumDeletionstoMakeStringBalancedLC1653 {
    public static void main(String[] args) {
        String s =  "aababbab"; //""baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int count = 0;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'b') {
                count++;
            } else if (count != 0) {
                result++;
                count--;
            }
        }

        return result;
    }
}
