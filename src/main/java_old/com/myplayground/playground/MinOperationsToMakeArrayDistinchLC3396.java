package com.myplayground.playground;

import java.util.HashSet;

public class MinOperationsToMakeArrayDistinchLC3396 {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,2,3,3,5,7};
        new MinOperationsToMakeArrayDistinchLC3396().minimumOperations(input);
    }

    public int minimumOperations(int[] nums) {
        int operations = 0;
        boolean[] seen = new boolean[128];
        for (int i=nums.length-1; i>=0; i--) {
            if (seen[nums[i]]) {
                return (i/3) + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}
