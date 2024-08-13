package com.myplayground.playground;

import java.util.Arrays;

public class ClimbingStairsLC70 {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        dp[0] = 1;
        int x = new ClimbingStairsLC70().stairs(dp, n);
        System.out.println(x);
    }

    public int stairs(int[] dp, int n) {
        if (n <= 1) return 1;
        if (dp[n] == 0) {
            dp[n] = stairs(dp,n-1) + stairs(dp,n-2);
        }
        return dp[n];
    }

}
