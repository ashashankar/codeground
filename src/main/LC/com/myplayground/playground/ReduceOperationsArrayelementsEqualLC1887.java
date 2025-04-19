package com.myplayground.playground;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReduceOperationsArrayelementsEqualLC1887 {

    public static void main (String[] args) {
        int[] nums = { 8, 5, 3, 2};
        System.out.println(reductionOperations(nums));
    }
    public static int reductionOperations(int[] nums) {
        int len = nums.length;
        int answer = 0;

        Arrays.sort(nums);
        for (int i=len-1; i>0 ; i-- ) {
            if (nums[i-1] != nums[i]) answer += len - i;
        }

        return answer;
    }
}
