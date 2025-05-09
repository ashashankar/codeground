package com.myplayground.playground;

import com.sun.source.tree.Tree;

import java.util.*;

public class AllNodesAtDistanceKInBinaryTreeLC863 {

    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        int target = 5;
        int distance = 2;
        TreeNode root = new TreeNode().constructBinaryTree(arr);
        TreeNode target_node = new TreeNode().getTreeNodeAddress(root, target);

        System.out.println(new AllNodesAtDistanceKInBinaryTreeLC863().distanceK(root, target_node , distance));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) return Arrays.asList(target.val);
        HashMap<TreeNode, ArrayList<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left !=null ) {
                map.computeIfAbsent(node.left, key-> new ArrayList<TreeNode>()).add(node);
                map.computeIfAbsent(node, key-> new ArrayList<TreeNode>()).add(node.left);
                q.offer(node.left);
            }

            if (node.right !=null ) {
                map.computeIfAbsent(node.right, key-> new ArrayList<TreeNode>()).add(node);
                map.computeIfAbsent(node, key-> new ArrayList<TreeNode>()).add(node.right);
                q.offer(node.right);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<Pair> dist_q = new LinkedList<>();
        dist_q.offer(new Pair(target, 0));
        visited.add(target);
        while (!dist_q.isEmpty()) {
            Pair values = dist_q.poll();
            int d = values.getDistance();
            if (d == k) {
                result.add(values.getTreeNode().val);
            } else {
                List<TreeNode> children = map.get(values.getTreeNode());
                if(children == null) continue;
                for (TreeNode c : children) {
                    if (!visited.contains(c)) {
                        visited.add(c);
                        dist_q.offer(new Pair(c, d+1));
                    }

                }
            }

        }
        return result;
    }
}