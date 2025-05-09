package com.myplayground.playground;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int target = 8;
        getCombinations(nums, new ArrayList<Integer>(), 0, 0, target);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static ArrayList<Integer> getCombinations(int[] nums, ArrayList<Integer> al, int sum, int idx, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(al));
            return al;
        }

        if (sum > target || idx == nums.length) {
            return al;
        }

        al.add(nums[idx]);
        getCombinations(nums, al, sum+nums[idx], idx, target);
        al.remove(al.size()-1);
        getCombinations(nums, al, sum, idx+1, target);

        return al;
    }
}
