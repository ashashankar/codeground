package com.myplayground.playground;

public class LC2639FindWidthOfColsOfAGrid {

    public static void main(String[] args) {
        int[][] grid = {{2911,-805,5477,-3349,163,-6644},{4851,2990,2578,1124,2897,-1781},{-2153,1774,-8238,-2894,4845,9608}};
        int[] len = new LC2639FindWidthOfColsOfAGrid().findColumnWidth(grid);
        System.out.println(len);
    }

    public int[] findColumnWidth(int[][] grid) {

        // String.valueOf(number)
        // Division

        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int num = grid[i][j];

                if (num <= 0) {
                    num = Math.abs(num);
                    count++;
                }

                while (num > 0) {
                    num = num / 10;
                    count++;
                }

                result[j] = Math.max(count, result[j]);


            }
        }

        return result;
    }
}
