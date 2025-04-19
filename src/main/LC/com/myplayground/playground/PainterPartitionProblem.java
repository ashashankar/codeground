package com.myplayground.playground;

public class PainterPartitionProblem {

    public static void main (String[] args) {
        int A = 4;
        int B = 10;
        int[] C = {1, 8, 11, 3};

    }
    public int paint(int A, int B, int[] C) {
        int sum = C[0];
        int maxVal = C[0];
        for (int k=1; k<C.length; k++) {
            sum += C[k];
            maxVal = Math.max(maxVal, C[k]);
        }
        int answer = 0;
        int l = maxVal;
        int r = sum;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (checkTime(C, mid, A)) {
                answer = mid;
                r = mid -1 ;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }


    public boolean checkTime(int[] C, int mid, int A) {
        int w = 1;
        int currentWork = 0;
        for (int i =0; i<C.length; i++) {
            if (currentWork <= mid) {
                currentWork += C[i];
            } else {
                w++;
                currentWork = C[i];
            }
        }
        if (w > A) {
            return false;
        }
        return true;
    }
}
