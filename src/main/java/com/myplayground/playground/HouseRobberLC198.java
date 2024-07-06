package com.myplayground.playground;

import java.util.Arrays;

public class HouseRobberLC198 {
    static int[] dp = null;
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int sum  = new HouseRobberLC198().maxSumSubSequence(nums, nums.length-1);
        System.out.println(sum);
    }

    public int maxSumSubSequence(int[] nums, int idx) {
        if (idx < 0) return 0;
        if (dp[idx] == -1) {
            if (nums[idx] < 0){
                dp[idx] += maxSumSubSequence(nums, idx-1);
            } else {
                int sum = 0;
                int sum1 = maxSumSubSequence(nums, idx-2) + nums[idx];
                int sum2 = maxSumSubSequence(nums, idx-1);
                 sum = Math.max(sum1,sum2 );
                dp[idx] =  sum;
            }
        }
        return dp[idx];
    }
}
