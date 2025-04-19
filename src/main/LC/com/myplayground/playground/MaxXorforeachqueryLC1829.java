package com.myplayground;

import java.util.Arrays;

public class MaxXorforeachqueryLC1829 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,3};
        int maxBit = 2;
        System.out.println(Arrays.toString(new MaxXorforeachqueryLC1829().getMaximumXor(nums, maxBit)));
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxBit = (1<<maximumBit) -1 ;
        int[] result = new int[nums.length];
        int xored = findXor(nums);

        for (int i=nums.length-1; i>=0; i--) {
            int val = xored ^ maxBit;
            result[nums.length-1-i] = val;
            xored ^= nums[i];
        }
        return result;
    }


    public int findXor(int[] nums) {
        int result = 0;
        for (int j=0; j<nums.length; j++) {
            result ^= nums[j];
        }
        return result;
    }
}
