package com.myplayground.temp;


import java.util.Arrays;

public class SegmentTrees {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 9, 1};
        int[] seg_array = new int[4*nums.length];
        buildSegmentTree(nums, 0, 0, nums.length-1, seg_array);
        System.out.println(Arrays.toString(seg_array));
    }

    public static void buildSegmentTree(int[] nums, int index, int left, int right, int[] seg_array) {
        if (left == right) {
            seg_array[index] = nums[right];
            return;
        }
        int mid = left + (right - left)/2;
        buildSegmentTree(nums, 2*index+1, left, mid, seg_array);
        buildSegmentTree(nums, 2*index+2, mid+1, right, seg_array);
        seg_array[index] = seg_array[2*index+1] + seg_array[2*index+2];
        return;
    }
}
class TreeNode {
    TreeNode left;
    TreeNode root;
    TreeNode right;
    int val = 0;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int getVal(){
        return this.val;
    }


}