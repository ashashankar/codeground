package com.myplayground.playground;

import java.util.Arrays;

public class ZAlgo {
    public static void main(String[] args) {
        int l = 0;

        String input = "xxyzxxyzwxxyzxxyzx";
        //bruteForce(input);
        String pattern = "xxyzx";
        String concatString = pattern+ "$"+ input;
        int[] Z = new int[concatString.length()];
        //createZArr(Z, concatString);
        for (int i=0; i<concatString.length(); ++i) {
            if (Z[i] == pattern.length()) {
                System.out.println(" Pattern found at index "+ (i - pattern.length() + 1));
            }
        }
        System.out.println(Integer.valueOf("1"));
    }

    private static void createZArr(int[] Z, String concatString) {
        //xxyzx$xxyzxxyzwxxyzxxyzx
        int n = concatString.length();
        int left =0; int right = 0;
        for (int i=1; i<n; ++i) {

            if(i > right) {
                left = right = i;

                while (right < n && concatString.charAt(left - right) == concatString.charAt(right)) {
                    right++;
                }
                Z[i] = right - left;
                right--;
            } else {
                int k = i- left;
                if (Z[k] < right - left +1) {
                    Z[i] = Z[k];
                } else {
                    left = i;
                    while (right < n && concatString.charAt(right - left) == concatString.charAt(right)) {
                        right++;
                    }
                    Z[i] = right - left;
                    right--;
                }
            }
        }
    }

    private static void bruteForce(String input) {
        int[] z = new int[input.length()];
        for(int i = 1; i< input.length(); i++) {
            int k = 0;
            int j= i;
            while (j< input.length() && input.charAt(j) == input.charAt(k)) {
                j++;
                k++;
            }
            z[i] = k;
        }
        System.out.println(Arrays.toString(z));
        int max = 0;
        int index = 0;
        for (int l=0; l<z.length; l++) {
            if (z[l] > max) {
                max = z[l];
                index = l;
            }
        }
        System.out.println("longest repeating substring is "+ input.substring(index, index+max));
    }
}
