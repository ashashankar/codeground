package com.myplayground.playground;

public class MaxLengthOfSubarrayWithPositiveCountLC1567 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,0,1};
        int len = getMaxLen(nums);
        System.out.println(len);
    }

    public static int getMaxLen(int[] nums) {
        int len = nums.length;
        int longest = 0;
        int latest_zero = -1;
        int earliest_negative = -1;
        int negative_count = 0;
        for (int i=0; i<len; i++) {
            if (nums[i] < 0) {
                if (earliest_negative == -1) {
                    earliest_negative = i;
                }
                negative_count++;
            } else if (nums[i] == 0) {
                latest_zero = i;
                earliest_negative = -1;
                negative_count = 0;
            }
            if (negative_count % 2 == 1) {
                longest = Math.max(longest, i - earliest_negative);
            } else {
                longest = Math.max(longest , i - latest_zero);
            }

        }
        return longest;
    }
}
