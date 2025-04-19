package com.myplayground.playground;

public class JumpGame2LC45 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(new JumpGame2LC45().jump(arr));
    }

    public int jump(int[] arr) {
        int jumps =0;
        int coverage = 0;
        int lastIdx = 0;
        for (int i=0; i<arr.length; i++) {
            coverage = Math.max(coverage, arr[i]+ i);
            if(lastIdx == i) {
                lastIdx = coverage;
                jumps++;
                if(coverage >= arr.length) return jumps;
            }
        }
        return jumps;
    }
}
