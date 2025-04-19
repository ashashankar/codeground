package com.myplayground.playground;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * All subset versions.
 * 1.get the number of subsets with sum = K for the given array
 * 2. genenrate all subsets brute force and optimized backtracking approach
 */
public class SubsetWithSumK {
    public static void main(String[] args) {
        int[] a = {5,2,7};
        int target = 7;
        int r = countOfSubsetsWithSumK(a, a.length, 0, target, 0);
        System.out.println(r);

        int[] b = {1,2,3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        generateAllSubsets(result, new ArrayList<Integer>(), b, 0);
        System.out.println("Size "+ result.size());
        System.out.println("Result "+ result);
        genearateAllSubsetsBF(b.length, b);
    }

    /**
     * Return count of subsets possible.
     * @param a
     * @param size
     * @param pos
     * @param target
     * @param sum
     * @return
     */
    public static int countOfSubsetsWithSumK(int[] a, int size, int pos, int target, int sum) {
        if (pos == size) {
            return (sum == target)? 1: 0;
        }
        sum = sum + a[pos];
        int x = countOfSubsetsWithSumK(a, size, pos+1, target, sum);
        sum = sum - a[pos];
        int y =countOfSubsetsWithSumK(a, size, pos+1, target, sum);
        return x+y;
    }
    public static void generateAllSubsets(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> subset, int[] b, int pos) {
        result.add(new ArrayList<>(subset));
        for (int i=pos; i<b.length; i++) {
            subset.add(b[i]);
            generateAllSubsets(result, subset, b, i+1);
            subset.remove(subset.size()-1);
        }

    }

    public static void genearateAllSubsetsBF(int n, int[] b) {
        int x = (1 << n);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int i=0; i<x; i++) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int j=0; j<n; j++) {
                if(checkbit(i, j)) {
                    result.add(b[j]);
                }
            }
            subsets.add(result);
        }
        System.out.println(subsets.size());
        System.out.println(subsets);
    }

    public static boolean checkbit(int  i, int j) {
        if (((i>>j) & 1) == 1) {
            return true;
        }
        return false;
    }
}
