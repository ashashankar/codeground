package com.myplayground.playground;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class SlidingWindowMaxLC239 {

    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5 };
        int len = 3;
        System.out.println(Arrays.toString(printMaxBF(arr, len)));
        //System.out.println(Arrays.toString(dequeueEfficientApproach(arr, len)));
    }

    public static int[] dequeueEfficientApproach(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k +1];

        int w = 0;
        for  ( int i=0; i < nums.length; i++ ) {

            if (!deque.isEmpty() && deque.peekFirst() == i -k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            //add to result after reading the first subarray
            if (i >= k-1) {
                result[w++] = nums[deque.peekFirst()];
            }

        }
        return result;
    }

    public static int[] printMaxBF(int[] a, int len) {

        int k = 0;
        int[] maxNum = new int [a.length - len + 1];


        for (int i=0; i<a.length-len+1; i++) {
            int num = a[i];
            for (int j=i; j<=i+len-1; j++) {
                 num = Math.max(a[j], num);

            }
            maxNum[k] = num;
            k++;
        }

        return maxNum;

    }
}
