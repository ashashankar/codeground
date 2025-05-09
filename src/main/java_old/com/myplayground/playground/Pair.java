package com.myplayground.playground;


public class Pair {

    int weight;
    int node;

    int row;
    int col;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    Pair(int w, int r, int c) {
        this.weight = w;
        this.row = r;
        this.col = c;
    }

    int distance;
    TreeNode treeNode ;
    Pair(TreeNode node, int distance) {
        this.treeNode = node;
        this.distance = distance;
    }

    public TreeNode getTreeNode() {
        return this.treeNode;
    }

    public int getDistance() {
        return this.distance;
    }
    int idx;
    int number;

    public int getWeight() {
        return this.weight;
    }
    public int getNode() {
        return this.node;
    }

    public int getRow() {
        return  this.row;
    }
    public int getCol() {
        return this.col;
    }

    public int getIdx() {
        return  this.node;
    }
    public int getNumber() {
        return this.weight;
    }
}
