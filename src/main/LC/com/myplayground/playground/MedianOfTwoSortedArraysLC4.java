package com.myplayground.playground;

public class MedianOfTwoSortedArraysLC4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3, 4};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1+len2];
        int i = 0;
        int j = 0;
        int k=0;
        while (i<len1 && j < len2 ) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                j++;
            } else {
                result[k] = nums1[i];
                i++;
            }


            k++;
        }
        while (i<len1) {
            result[k] = nums1[i];
            k++;
            i++;
        }

        while (j<len2) {
            result[k] = nums2[j];
            k++;
            j++;
        }
        double answer = 0;
        if (result.length % 2 == 0) {
            int num = result.length/2;
            answer = (float) (result[num] + result[num-1])/2;
        } else {
            answer = result[result.length/2];
        }
        return answer;
    }
}
