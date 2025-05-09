package com.myplayground.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementIILC503 {
    public static void main(String[] args) {
        int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
        int[] result = new NextGreaterElementIILC503().nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] nextGreaterElements(int[] nums)  {
    Stack<Integer> st = new Stack<>();
    int[] result = new int[nums.length];
    HashMap<Integer, Integer> hm = new HashMap<>();
    int len = nums.length * 2-1;
        for (int idx =len; idx >=0; idx--) {
        int i = (idx%nums.length);
        while(!st.isEmpty() && st.peek() <= nums[i]) {
            st.pop();
        }
        if (idx < nums.length) {
            if (!st.isEmpty()) {
                result[idx] = st.peek();
            } else {
                result[idx] = -1;
            }
        }
        st.push(nums[i]);
    }
    return result;
    }
}
