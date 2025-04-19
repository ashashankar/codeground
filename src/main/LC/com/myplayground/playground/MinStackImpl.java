package com.myplayground.playground;

import java.util.Stack;

public class MinStackImpl {
    public static void main(String[] args) {

        Minstack minstack = new Minstack();
        minstack.push(10);
        System.out.println(minstack.getMin());
        minstack.push(2);
        System.out.println(minstack.getMin());
        minstack.push(8);
        System.out.println(minstack.getMin());
        minstack.push(1);
        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.getMin());
        minstack.push(100);
        System.out.println(minstack.getMin());
        minstack.push(-1);
        System.out.println(minstack.getMin());
        minstack.pop();
        minstack.pop();
        System.out.println(minstack.getMin());




    }
}

class Minstack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<>();
    public int getMin() {
        return min;
    }

    public void push(int x) {
        //min = Math.min(x, min);
        if (x < min) {
            st.push(2*x - min);
            min = x;
        } else {
            st.push(x);
        }
    }

    public void pop() {
        if (st.peek() <min) {
            int val = 2 * min - st.peek();
            min = val;
        }
        st.pop();
    }
}
