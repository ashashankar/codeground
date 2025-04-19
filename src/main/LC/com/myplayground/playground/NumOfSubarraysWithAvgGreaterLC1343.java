package com.myplayground.playground;

public class NumOfSubarraysWithAvgGreaterLC1343 {
    public static void main(String[] args) {
        int[] A = {2,2,2,2,5,5,5,8};
        int k = 3;
        int target = 4;
        System.out.println(getCount(A, k, target));
    }

    public static int getCount(int[] A, int k, int target)
    {
        int sum = 0;
        double answer = 0;
        int count = 0;
        for (int i=0; i<k; i++) {
            sum += A[i];
        }
        answer = (double)sum/k;
        if (answer >= target) {
            count++;
        }

        int l = 1;
        int m = l+k-1;

        while (m < A.length) {
            sum -= A[l-1];
            sum += A[m];
            answer = (double)sum/k;
            if (answer >= target) {
                count++;
            }
            l++;
            m++;
        }
        return count;
    }
}
