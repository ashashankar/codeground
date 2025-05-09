package com.myplayground.playground;

import java.util.Stack;

/**
 * Sort stack using another stack
 */
public class SortStack {
    public static void  main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.add(4);
        st1.add(6);
        st1.add(-5);
        st1.add(0);
        st1.add(-1);
        st1.add(2);
        st1.add(5);
        st1.add(3);
        st1.add(1);
        Stack<Integer> st2 = new Stack<>();
        while (!st1.isEmpty()) {
            int x = st1.pop();
            while (!st2.isEmpty() && x < st2.peek()) {
                int n = st2.pop();
                st1.push(n);
            }
            st2.push(x);
        }

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        System.out.println(st1);
    }
}
