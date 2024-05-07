package com.myplayground.playground;

import java.util.Arrays;
import java.util.Stack;
public class NearestSmallestElement {

    public static void main(String[] args) {
        int[] arr = {10, 3, 4, 5, 10, 12, 8 };
        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack();

        for (int i=1; i<arr.length; i++) {
            while (!st.isEmpty() && st.peek()> arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}
