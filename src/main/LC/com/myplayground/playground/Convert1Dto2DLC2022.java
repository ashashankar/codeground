package com.myplayground.playground;

import java.util.Arrays;

public class Convert1Dto2DLC2022 {
    public static void main(String[] args) {

        int[] o = {1,2};
        int m = 1;
        int n = 1;
        System.out.println(Arrays.deepToString(new Convert1Dto2DLC2022().construct2DArray(o, m, n)));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        //dimensions are smaller than the original
        if (m*n < original.length) return new int[0][0];

        int idx = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result[i][j] = original[idx++];
            }
        }
        return result;
    }
}
