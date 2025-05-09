package com.myplayground.playground;

import java.util.ArrayList;
import java.util.List;

public class subsetLC78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new subsetLC78().backtrack(nums, new ArrayList<>(), 0);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();
    public void backtrack(int[] nums, ArrayList<Integer> temp, int idx) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        };
        temp.add(nums[idx]);
        backtrack(nums, temp, idx+1);
        temp.remove(temp.size()-1);
        backtrack(nums, temp, idx+1);
    }
}
