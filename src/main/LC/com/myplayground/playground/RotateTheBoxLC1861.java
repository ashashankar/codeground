package com.myplayground.playground;

import java.util.Arrays;

public class RotateTheBoxLC1861 {
    public static void main(String[] args) {
        char[][] box = {{'#','.','*','.'},{'#','#','*','.'}};
        char[][] result = new RotateTheBoxLC1861().rotate(box);
        System.out.println(Arrays.deepToString(result));
    }

    public char[][] rotate(char[][] box) {
        int r = box.length;
        int c = box[0].length;
        for (int i=0; i<r; i++) {
            int k = c -1;
            for (int j=c-1; j>=0; j--) {
                if (box[i][j] == '#') {
                    char temp = box[i][j];
                    box[i][j] = box[i][k];
                    box[i][k] = temp;
                    k -= 1;
                } else if (box[i][j] == '*') {
                    k = j -1;
                }
            }
        }

        char[][] result = new char[c][r];
        int k = r-1;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                result[j][i] = box[k][j];

            }
            k  = k -1;
        }
        return result;
    }
}
