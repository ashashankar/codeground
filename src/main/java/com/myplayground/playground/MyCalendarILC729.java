package com.myplayground.playground;

import java.util.ArrayList;

public class MyCalendarILC729 {
    BSTNode root = null;
    MyCalendarILC729() {

    }
    public static void main(String[] args) {
        ArrayList<Boolean> answer = new ArrayList<>();
        answer.add(new MyCalendarILC729().book(10, 20));
        answer.add(new MyCalendarILC729().book(15, 25));
        answer.add(new MyCalendarILC729().book(20, 30));
        System.out.println(answer);
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new BSTNode(start, end);
            return true;
        }
        return root.insert(start, end);
    }
}


class BSTNode {
    BSTNode left ;
    BSTNode right;

    int s ;
    int e;

    BSTNode(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public boolean insert(int start, int end) {
        BSTNode curr = this;
        while (true) {
            if (start >= curr.e) {
                //go right
                if (curr.right == null) {
                    curr.right = new BSTNode(start, end);
                    return true;
                }
                curr = curr.right;

            } else if (end <= curr.s) {
                // go left
                if (curr.left == null) {
                    curr.left = new BSTNode(start, end);
                    return true;
                }
                curr = curr.left;

            } else {
                return false;
            }
        }
    }
}