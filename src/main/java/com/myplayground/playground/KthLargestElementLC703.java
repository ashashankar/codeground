package com.myplayground.playground;

import java.util.PriorityQueue;

public class KthLargestElementLC703 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int size = 0;

    public static void main(String[] args) {
        size = 3;
        int[] nums = {4, 5,7,7, 7, 1, 22};
        for (int i=0; i<nums.length; i++) {
            add(nums[i]);
        }
        System.out.println(KthLargest(size, nums));
    }

    public static int KthLargest (int k, int[] nums) {
        return pq.peek();
    }

    public static void add(int n) {
        pq.add(n);
        while(pq.size() > size) {
            pq.poll();
        }
    }
}
