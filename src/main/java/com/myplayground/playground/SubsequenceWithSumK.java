package com.myplayground.temp;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8};
        int k = 8;
        new SubsequenceWithSumK().printSubequenceWithSumK(arr, 0, 0, k, new ArrayList<Integer>());
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

        if (sum == k) {
            System.out.println(values);
            return true;
        }
        if (sum > k) {
            return false;
        }
        if (idx >= arr.length) return false;
        sum += arr[idx];
        values.add(arr[idx]);
        boolean found = printOnlyOneSubequenceWithSumK(arr, idx+1,sum,  k, values);
        if (!found) {
            sum -= arr[idx];
            values.remove(values.size()-1);
            printOnlyOneSubequenceWithSumK(arr, idx+1,sum,  k, values);
        }
        return found;
    }
}
