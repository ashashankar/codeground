package com.myplayground.playground;

import javax.swing.tree.TreeNode;
import java.util.*;

public class AllNodesAtDistanceKInBinaryTreeLC863 {

    public static void main(String[] args) {
        System.out.println(new AllNodesAtDistanceKInBinaryTreeLC863().distanceK(null, null, 2));
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
                result.add(values.getNode().val);
            } else {
                List<TreeNode> children = map.get(values.getNode());
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

class Pair {
    int distance;
    TreeNode node;
    Pair(TreeNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public TreeNode getNode() {
        return this.node;
    }
}