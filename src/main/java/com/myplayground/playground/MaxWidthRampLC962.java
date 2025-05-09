package com.myplayground.playground;

public class MaxWidthRampLC962 {

    public static void main(String[] args) {
        int[] nums = {6,0,8,2,1,5};
        System.out.println(new MaxWidthRampLC962().maxWidthRamp(nums));
    }
    public int maxWidthRamp(int[] nums) {
        int maxwidth = 0;
        int[] maxvals = new int[nums.length];
        int max = -1;
        for (int i=nums.length-1; i>=0; i--) {
            max = Math.max(nums[i], max);
            maxvals[i] = max;
        }

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[left] <= maxvals[right]) {
                maxwidth = Math.max(maxwidth, right - left);
                right++;
            } else {
                left++;
            }
        }

        return maxwidth;
    }
}
