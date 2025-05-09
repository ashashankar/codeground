package com.myplayground.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RangeSumofSortedSubarraySumsLC1508 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 5;
        int sum = rangeSum(nums, n, left, right);
        System.out.println(sum);
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int sum = 0;
        int MOD = (int)1e9 + 7;
        ArrayList<Integer> subarraySums = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int currSum = 0;
            for (int j=i; j<n; j++) {
                currSum = (currSum + nums[j]) % MOD;
                subarraySums.add(currSum);
            }
        }
        Collections.sort(subarraySums);
        for (int i= left-1; i<right; i++) {
            sum = (sum + subarraySums.get(i))  % MOD;
        }
        return sum;
    }


}
