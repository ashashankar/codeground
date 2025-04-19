package com.myplayground.playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Binary Search with sliding window
 */
public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[] nums ={1,3,1};
        int k = 1;
        System.out.println(findSmallestDistance(nums, k));
    }

    public static int findSmallestDistanceBruteForce(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i == j) continue;
                int dist = Math.abs(nums[j] - nums[i]);
                pq.add(dist);
                while (!pq.isEmpty() && pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static int findSmallestDistance(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0;
        int r = nums[len -1];
        while (l<r) {
            int mid = l + (r - l)/2;
            int pairs = checkPairs(mid, nums);
            if (pairs < k) {
                l =  mid +1;
            } else {
                r = mid;
            }
            result = r;
        }

        return result;
    }

    public static int checkPairs(int diff, int[] nums) {
        int count = 0;
        int l = 0;
        for (int r=1; r<nums.length; r++) {
            while (nums[r] - nums[l] > diff) {
                l++;
            }
            count += r - l;
        }
        return count;
    }
}
