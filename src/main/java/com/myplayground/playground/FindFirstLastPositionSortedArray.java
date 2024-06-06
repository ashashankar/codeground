package com.myplayground.playground;

import java.util.Arrays;

public class FindFirstLastPositionSortedArray {
    public static void main(String[] args) {
        int[] nums = {2};
        int target = 2;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static  int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int lowIdx = getLowerBound(nums, target);
        if (lowIdx <0 || nums[lowIdx] != target) return result;
        int upIdx = getUpperBound(nums, target);
        if (upIdx < 0 || upIdx > nums.length -1 || nums[upIdx] != target) {
            return result;
        }

        result[0] = lowIdx;
        result[1] = upIdx;
        return result;
    }

    public static int getLowerBound(int[] nums, int target) {

        int l = 0;
        int r= nums.length -1;
        int lowerIdx = -1;
        while (l<=r) {
            int mid = l+ (r - l)/2;
            if (nums[mid] >= target) {
                lowerIdx = mid;
                r = mid -1;
            }  else {
                l = mid +1;
            }
        }
        return lowerIdx;
    }

    public static int getUpperBound(int[] nums, int target) {
        int l = 0;
        int r= nums.length -1;
        int upperIdx = nums.length;
        while (l<=r) {
            int mid = l+ (r - l)/2;
            if (nums[mid] > target) {
                upperIdx = mid;
                r = mid -1;
            }  else {

                l = mid + 1;
            }
        }
        return upperIdx-1;
    }
}
