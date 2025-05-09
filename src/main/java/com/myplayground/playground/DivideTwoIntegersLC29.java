package com.myplayground.playground;

public class DivideTwoIntegersLC29 {

    public static void main(String[] args) {
        System.out.println(divide(-1, -1));
    }


    public static int divide(int dividend, int divisor) {
        boolean sign = true;

        if (dividend >= 0 && divisor < 0) sign = false;
        if (divisor >= 0 && dividend < 0) sign = false;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        if (n == d) return sign?1:-1;
        int answer = 0;
        while (n >= d) {
            int count = 0;
            while (n > d * (1 << count +1)) {
                count++;
            }
            n =  n - (d * (1 << count));
            answer += (1 << count);
        }

        if (answer >= Integer.MAX_VALUE && sign) return Integer.MAX_VALUE;
        if (answer >= Integer.MAX_VALUE && !sign) return Integer.MIN_VALUE;
        return sign?answer:-answer;
    }

    /**
     * Brute force. does not handle large numbers
     * @param dividend
     * @param divisor
     * @return
     */
    public static int dividebf(int dividend, int divisor) {
        boolean isNegative = false;
        boolean isPositive = false;
        if (divisor<0 && dividend<0) {
            isPositive = true;
        }

        if (!isPositive && dividend < 0) {
            isNegative = true;
            dividend = dividend * -1;

        } else if (!isPositive && divisor < 0) {
            divisor = divisor * -1;
            isNegative = true;
        }

        if (dividend == 0) return 0;
        int count = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            count++;
        }
        return (isNegative ? -count  : count);
    }
}
