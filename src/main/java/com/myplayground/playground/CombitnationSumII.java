package com.myplayground.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombitnationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target  = 8;
        combinationSum2(candidates, target);
        System.out.println(combinations);
    }
    static List<List<Integer>> combinations = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, new ArrayList<Integer>());
        return combinations;
    }

    public static void backtrack(int[] canditates, int start, int total, int target, ArrayList<Integer> result) {
        if (total == target) {
            combinations.add(new ArrayList<>(result));
            return;
        }
        if (total > target || start == canditates.length) return;

        result.add(canditates[start]);
        backtrack(canditates, start+1, total+canditates[start], target, result);
        result.remove(result.size()-1);
        while (start + 1 < canditates.length && canditates[start +1] == canditates[start])
            start++;
        backtrack(canditates, start+1, total, target, result);
    }
}
