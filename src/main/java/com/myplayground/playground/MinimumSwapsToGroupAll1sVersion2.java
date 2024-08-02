package com.myplayground.playground;

public class MinimumSwapsToGroupAll1sVersion2 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,0};
        int x = minSwap(nums);
        System.out.println(x);
    }

    public static int minSwap(int[] nums) {
        int ones = 0;
        int n = nums.length;
        for (int i:nums) {
            if (i == 1) ones++;
        }
        int windowOnes  = 0;
        int maxWindow = 0;
        for (int i=0; i< ones; i++) {
            if (nums[i] == 1) windowOnes++;
            maxWindow = Math.max(windowOnes, maxWindow);
        }

        for (int i=ones; i<2*nums.length; i++) {
            if (nums[(i-ones)%n] == 1) {
                windowOnes--;
            }
            if (nums[i%n] == 1) windowOnes++;
            maxWindow = Math.max(windowOnes, maxWindow);
        }
        return Math.abs(ones - maxWindow);
    }
}
