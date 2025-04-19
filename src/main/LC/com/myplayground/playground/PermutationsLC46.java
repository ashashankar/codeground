package com.myplayground.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PermutationsLC46 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] a = {1,2,3};
        HashSet<Integer> hs = new HashSet<>();
        generatePermuations(result, new ArrayList<>(), a, hs);
        System.out.println("All "  +result);

    }
    public static void generatePermuations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> permu, int[] a, HashSet<Integer> hs) {
        if (permu.size() == a.length) {
            result.add(new ArrayList<>(permu));
            return;
        }
        for (int i=0; i<a.length; i++) {
            if (hs.contains(a[i])) continue;
            permu.add(a[i]);
            hs.add(a[i]);
            generatePermuations(result, permu, a, hs);
            permu.remove(permu.size()-1);
            hs.remove(a[i]);
        }
    }
}
