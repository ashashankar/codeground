package com.myplayground.playground;

import java.util.*;

public class flipColumnsForEqualRowsLC1072 {
    public static void main(String[] str) {
        int matrix[][] = {{0,0,0}, {0, 1, 0}, {1, 0, 0}};//{{0,0,0}, {0, 0, 0},{1, 1,1}};//{{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,1,1,0,1,1,1,0,1,1,1}};

        int c = new flipColumnsForEqualRowsLC1072().maxEqualRowsAfterFlips(matrix);
        System.out.println(c);
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int result = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i=0; i<r; i++) {
            StringBuilder sb = new StringBuilder();
            boolean toFlip = false;
            if(matrix[i][0] == 1) {
                toFlip = true;
            }
            for (int j=0; j<c; j++) {

                if (toFlip) {
                    matrix[i][j] =  matrix[i][j] ^ 1;
                }
                sb.append(matrix[i][j]);
            }

            hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
        }

        for (Map.Entry<String, Integer> me : hm.entrySet()) {
            result = Math.max(me.getValue(), result);
        }


        return result;
    }
}
