package com.myplayground.playground;

import java.util.HashSet;

public class MakeArrayZeroBySubsEqualAmountLC2357 {
    public static void main(String[] args) {
        int[] nums = {1,5,0,3,5};
        System.out.println(new MakeArrayZeroBySubsEqualAmountLC2357().minimumOperations(nums));
    }

    //o(N) space o(number of unique elements)
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i: nums) {
            hs.add(i);
        }
        return hs.size();
    }

    // O(N2)
    public int minimumOperations_bruteForce(int[] nums) {
        int result=0;
        for (int i=0; i<nums.length; i++) {
            int min = findMin(nums);
            if (min != 0) {
                result += 1;
                for (int j=0; j<nums.length; j++) {
                    if (nums[j] > 0) {
                        nums[j] = nums[j] - min;

                    }
                }
            }


        }
        return result;
    }

    public int findMin(int[] nums) {
        int val = Integer.MAX_VALUE;
        for (int i: nums) {
            if (i == 0) continue;
            val = Math.min(val, i);
        }

        return (val==Integer.MAX_VALUE)? 0 : val;
    }
}
