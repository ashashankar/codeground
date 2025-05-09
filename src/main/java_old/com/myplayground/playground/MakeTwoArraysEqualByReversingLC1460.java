package com.myplayground.playground;

public class MakeTwoArraysEqualByReversingLC1460 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(canBeEqual(nums, arr));
    }
    public static boolean canBeEqual(int[] target, int[] arr) {
        int[] resultA = new int[1001];
        for (int i=0; i<target.length; i++) {
            resultA[target[i]]++;
            resultA[arr[i]]--;
        }

        for (int i=0; i< resultA.length; i++){
            if (resultA[i] != 0) {
                return false;
            }
        }
        return true;
    }
}


