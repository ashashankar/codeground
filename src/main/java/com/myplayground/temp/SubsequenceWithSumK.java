package com.myplayground.temp;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8};
        int k = 8;
        int result = new SubsequenceWithSumK().countAllSubsequencesWithSumK(arr, 0, 0, k, new ArrayList<Integer>());
        System.out.println(result);
    }

    public void printSubequenceWithSumK(int[] arr, int idx, int sum, int k, List<Integer> values) {

        if (sum == k) {
            System.out.println(values);
            return;
        }
        if (sum > k) {
            return;
        }
        if (idx >= arr.length) return;
        sum += arr[idx];
        values.add(arr[idx]);
        printSubequenceWithSumK(arr, idx+1,sum,  k, values);
        sum -= arr[idx];
        values.remove(values.size()-1);
        printSubequenceWithSumK(arr, idx+1,sum,  k, values);

    }

    public boolean printOnlyOneSubequenceWithSumK(int[] arr, int idx, int sum, int k, List<Integer> values) {

        if (idx == arr.length) {
            if (sum == k) {
                System.out.println(values);
                return true;
            } else {
                return false;
            }

        }

        sum += arr[idx];
        values.add(arr[idx]);
        boolean found = printOnlyOneSubequenceWithSumK(arr, idx+1,sum,  k, values);
        if (found) return true;

        sum -= arr[idx];
        values.remove(values.size()-1);
        if(printOnlyOneSubequenceWithSumK(arr, idx + 1, sum, k, values)) return true;

        return false;
    }

    public int countAllSubsequencesWithSumK(int[] arr, int idx, int sum, int k, List<Integer> values) {

        if (idx == arr.length) {
            if (sum == k) {
                return 1;
            } else {
                return 0;
            }

        }

        sum += arr[idx];
        values.add(arr[idx]);
        int left = countAllSubsequencesWithSumK(arr, idx+1,sum,  k, values);

        sum -= arr[idx];
        values.remove(values.size()-1);
        int right = countAllSubsequencesWithSumK(arr, idx + 1, sum, k, values);

        return left + right;
    }
}
