package com.myplayground.playground;


import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
      Integer val;
      TreeNode left;
      TreeNode right;
      TreeNode() { }
      TreeNode(Integer x) { val = x; }


    public TreeNode constructBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (i<arr.length) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
                i++;
            }

            if (i<arr.length) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
                i++;
            }
        }
        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                System.out.print(curr.val + " ");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();

    }

    public TreeNode getTreeNodeAddress(TreeNode root, int val) {
          if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null && curr.val == val) return curr;
            if (curr != null) {
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return null;
    }
 }