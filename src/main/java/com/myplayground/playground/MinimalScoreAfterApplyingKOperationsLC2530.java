package com.myplayground.playground;

import lombok.Getter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimalScoreAfterApplyingKOperationsLC2530 {
    public static void main(String[] args) {
        int[] nums = {10,10,10,10,10};
        int k = 5;
        System.out.println(new MinimalScoreAfterApplyingKOperationsLC2530().maxKelements(nums, k));
    }

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        for (int i=0; i<nums.length; i++) {
            pq.offer(new Pair(i, nums[i]));
        }
        int sum = 0;
        while (k > 0) {
            Pair largestPair = pq.poll();
            sum += largestPair.getValue();
            int replace = (int)Math.ceil(largestPair.getValue() / 3);
            pq.offer(new Pair(largestPair.getIdx(), replace));
            k--;
        }
        return sum;
    }
}
