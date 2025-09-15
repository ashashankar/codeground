package com.myplayground.playground;

import java.util.HashMap;
import java.util.*;

public class FrogJumpLC403 {

    public static void main(String[] args) {
        int[] stones = {0,1,2,3,4,8,9,11};

        System.out.println(canCross(stones));
    }

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[0] + 1 != stones[1]) return false;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<stones.length; i++) {
            hm.put(stones[i], i);
        }
        Boolean[][] dp = new Boolean[n][n+1];
        return solve(stones[1], 1, hm, dp, stones);
    }

    public static boolean solve(int index, int jump, Map<Integer , Integer> hm, Boolean[][] dp, int[] stones) {
        if(index == stones.length-1) return true;
        if (index >= stones.length) return false;
        if (dp[index][jump] != null) return dp[index][jump];

        for (int i=jump-1; i<=jump+1; i++) {
            int nextStone = stones[i];
            if (i > 0 && hm.containsKey(nextStone)) {
                dp[index][jump] = solve(hm.get(nextStone), i, hm, dp, stones);
                if (dp[index][jump]) return true;
            }
        }

        return dp[index][jump];
    }
}
