package com.myplayground.playground;

import java.util.Arrays;

public class PerfectSquaresLC279 {
    /**
     * dp expression
     * dp[i] = 1 + min(dp[i - x^2])  for all x^2 <= i
     * @param args
     */
    public static void main(String[] args) {
        int n = 16;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //System.out.println((7<<1));
        int answer = new PerfectSquaresLC279().perfectSquare(n, dp);

        System.out.println(answer);
    }
    public int perfectSquare(int n, int[] dp) {
        System.out.println(n);
        if (n == 0) return 0;

        if(dp[n] == -1) {
            int answer = Integer.MAX_VALUE;
            for (int i=1; i<=Math.sqrt(n); i++) {
                answer = Math.min(perfectSquare(n-(i*i), dp), answer);
            }
            dp[n] = 1+answer;
        }

        return dp[n];
    }
}
