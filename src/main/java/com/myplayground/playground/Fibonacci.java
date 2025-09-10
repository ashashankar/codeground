package com.myplayground.temp;

import java.util.Arrays;

/**
 * This class shows 4 implemenations for  fibonacci
 * 1.recursion ,
 * 2.memoization
 * 3.tabulation implemenation.
 * 4. iterative - o(1) space
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(fibonacci(n));

        //Memoization improvement
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacci_memo(n, dp));

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibonacci_tabulation(fibonacci_tabulation(n, dp));

        System.out.println(fibonacci_iterative(n));
    }

    //recursion o(2^n)
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if(n == 1) return 1;

        int x = fibonacci(n-1) + fibonacci(n-2);
        return x;
    }

    //memoization time (n) and space - recursion stack + dp array ->o(n + n) ~ o(n)
    public static int fibonacci_memo(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibonacci_memo(n-1, dp) + fibonacci_memo(n-2, dp);
        return dp[n];
    }

    //Tabulation -> improved space by eliminating the stack space. time and space o(n).
    public static int fibonacci_tabulation(int n, int[] dp) {
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * In this approach space complexity is o(1). Time o(1)
     */
    public static int fibonacci_iterative(int n) {
        int prev = 1;
        int prev2 = 0;
        for (int i=2; i<=n; i++) {
            int sum = prev + prev2;
            prev2 = prev;
            prev = sum;
        }
        return prev;
    }
}
