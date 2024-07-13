package com.myplayground.playground;

import java.util.Arrays;

public class UniquePathsLC63 {
    static int[][] dp = null;
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] A = new int[m][n];
        A[1][1] = 1;
        dp = new int[m][3];
        Arrays.stream(dp).forEach(a->Arrays.fill(a, -1));
        System.out.println(findPath(A, dp, n-1, m-1));
    }

    public static int findPath(int[][] A, int[][] dp,int i, int j) {

        if (i <0 || j <0) return 0;
        if (A[i][j] == 1) {
            dp[i][j] = 1;
        } else {
            if (dp[i][j] != -1) return dp[i][j];
            dp[i][j] = findPath(A, dp, i, j-1) + findPath(A, dp, i-1, j);
        }
        return dp[i][j];
    }
}
