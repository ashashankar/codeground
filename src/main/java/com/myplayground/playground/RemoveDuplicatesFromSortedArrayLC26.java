package com.myplayground.playground;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayLC26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 4, 5};
        new RemoveDuplicatesFromSortedArrayLC26().sort(nums);
    }

    public static void sort(int[] nums) {
        int idx = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        System.out.println("number of unique elements " + Arrays.toString(nums));
    }
}
