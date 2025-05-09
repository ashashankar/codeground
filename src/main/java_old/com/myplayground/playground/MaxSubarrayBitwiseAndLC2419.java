package com.myplayground.playground;

public class MaxSubarrayBitwiseAndLC2419 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2};
        System.out.println(new MaxSubarrayBitwiseAndLC2419().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int result = 0;
        int size = 0;
        int currmax = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > currmax) {
                currmax = nums[i];
                size = 1;
                result = 0;
            } else if (nums[i] == currmax) {
                size += 1;
            } else {

                size = 0;

            }
            result = Math.max(result, size);
        }
        return result;
    }

    public int getMaxSizeApproach2(int[] nums) {
        int max = 0;
        for (int i: nums) {
            max = Math.max(i, max);
        }
        int size = 0;
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == max) {
                size++;
            } else {
                size = 0;
            }
            result = Math.max(result, size);
        }
        return result;
    }
}
