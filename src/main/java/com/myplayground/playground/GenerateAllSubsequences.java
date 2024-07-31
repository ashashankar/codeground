package com.myplayground.playground;

import java.util.ArrayList;

public class GenerateAllSubsequences {
    public static void main(String[] args) {
        int[] x = {1,2,3};
        generate(x, 0, new ArrayList<>());
    }

    public static void generate(int[] x, int i, ArrayList<Integer> list) {
        if (i == x.length) {
            System.out.println(list);
            return;
        };

        list.add(x[i]);
        generate(x, i+1, list);
        list.remove(list.size()-1);
        generate(x, i+1, list);

    }
}
