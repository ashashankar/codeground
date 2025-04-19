package com.myplayground.playground;

public class BinaryTreeMaxPathSum {
    static TreeNode root = new TreeNode(-10);
    public static void main(String[] args){
        Integer[] nums = {-3};//{-10, 9, 20, null, null, 15 , 7 };//{1,2};
        root = SerializeABinaryTree.constructTree(nums);
        System.out.println(result);
    }

    static int result = Integer.MIN_VALUE;
    public static int travese(TreeNode root) {
        if (root == null) return 0;
        int leftSum = travese(root.left);
        int rightSum = travese(root.right);
        leftSum = Math.max(leftSum, 0);
        rightSum = Math.max(rightSum, 0);
        result = Math.max(result, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum , rightSum);
    }
}
