package com.myplayground.playground;

/**
 * derteemine if lucky number
 * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.
 *
 * Given a ticket number n, determine if it's lucky or not.
 */
public class LuckyNumber {

    public static void main(String[] args) {
        int n = 1230;
        System.out.println(solution(n));
    }
    public static boolean solution(int n) {

        String num = n+"";
        int len = num.length();
        int sum = 0;
        for (int i=0; i< len/2; i++) {
            int l = num.charAt(i) - '0';
            int r =  num.charAt(len - i - 1) - '0';
            sum +=  l -r;
        }

       return (sum ==0);
    }

}

