package com.myplayground.playground;

import java.util.LinkedList;

public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        int[] nodes = {4,2,8};
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int i : nodes) {
            ListNode node = new ListNode(i);
            dummy.next = node;
            dummy = dummy.next;
        }
        Integer[] nums = {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3};

        TreeNode root = SerializeABinaryTree.constructTree(nums);
        boolean answer = new LinkedListInBinaryTree().checkPath(head.next, root);
        System.out.println(" Linked List available in BT "+ answer);
    }

    public boolean checkPath(ListNode h, TreeNode root) {
        if (root == null) return false;
        if (isPath(h, root)) return true;
        return (checkPath(h, root.left) || checkPath(h , root.right));
    }


    public boolean isPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (root.val != head.val) {
           return false;
        }
        boolean leftResult = isPath(head.next, root.left);
        boolean rightResult = isPath(head.next, root.right);
        return (leftResult || rightResult);
    }
}
