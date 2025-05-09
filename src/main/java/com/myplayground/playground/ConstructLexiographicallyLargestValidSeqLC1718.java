package com.myplayground.playground;

import java.util.Arrays;
import java.util.HashSet;

public class ConstructLexiographicallyLargestValidSeqLC1718 {
    HashSet<Integer> used = new HashSet<>();
    static int len = 0;
    public static void main(String[] args) {
        int n = 5;
        len = (2 * n) -1;
        new ConstructLexiographicallyLargestValidSeqLC1718().construct(n);
    }

    public void construct(int n) {
        backtrack(0, n);
        System.out.println(Arrays.toString(result));
    }
    int[] result = new int[len];
    public boolean backtrack(int index, int n) {
        if (index == len) return true;
        for (int num=n; num>0; num--) {
            if (used.contains(num)) continue;
            if (num > 1 && (index + num >= len ||  result[index + num] != 0)) continue;

            used.add(num);
            result[index] = num;
            if (num > 1) {
                result[index + num] = num;
            }
            int j = index + 1;
            while (j<len && result[j] > 0){
                j += 1;
            }
            if (backtrack(j, n)) return true;

            used.remove(num);
            result[index] = 0;
            if (num > 1) {
                result[index + num] = 0;
            }
        }
        return false;
    }
}
