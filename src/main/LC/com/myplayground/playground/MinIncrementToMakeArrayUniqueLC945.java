package com.myplayground.playground;

import java.util.Arrays;

public class MinIncrementToMakeArrayUniqueLC945 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};
        System.out.println(new MinIncrementToMakeArrayUniqueLC945().minIncrementForUnique(nums));
    }
    public int minIncrementForUnique(int[] nums) {

        int answer = 0;
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                answer += (nums[i-1] + 1) - nums[i];
                nums[i] = nums[i-1] + 1;

            }
        }
        return answer;
    }
}
