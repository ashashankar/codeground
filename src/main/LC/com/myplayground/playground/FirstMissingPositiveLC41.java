package com.myplayground.playground;

import java.util.Arrays;
public class FirstMissingPositiveLC41 {
    public static void main(String[] args) {
        int[] a = {3,4,-1,1};
        System.out.println(firstMissingPositive(a));
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < nums.length) {
            if (nums[i] >0 && nums[i] < n) {
                int correctIdx = nums[i] -1;
                if (nums[correctIdx] != nums[i]) {
                    swap(nums,  correctIdx, i);
                } else {
                    i++;
                }


            } else {
                i++;
            }
        }
        int result = 0;
        System.out.println(Arrays.toString(nums));
        for (int j=0; j<n; j++) {
            if ((nums[j]-1) != j) {
                result = j+1;
                return result;
            }
        }
        return n+1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
