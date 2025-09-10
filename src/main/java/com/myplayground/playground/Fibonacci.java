package com.myplayground.temp;

import java.util.Arrays;

/**
 * This class show fibonacci recursion , memoization and tabulation implemenation.
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
}
