package com.myplayground.temp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsequencesPrint {
    public static void main(String[] args) {

        int[] values = {3,5,1,2};
        new SubsequencesPrint().printAllSubsequences(new ArrayList<Integer>(), 0, values);

    }

    public void printAllSubsequences(List<Integer> arr, int idx, int[] values){
        if (idx >= values.length) {
            System.out.println(arr);
            return;
        }
        arr.add(values[idx]);
        printAllSubsequences(arr, idx+1, values);
        arr.remove(arr.size()-1);
        printAllSubsequences(arr, idx+1, values);
    }
}
