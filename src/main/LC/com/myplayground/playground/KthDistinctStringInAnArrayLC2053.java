package com.myplayground.playground;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInAnArrayLC2053 {
    public static void main(String[] args) {
        String[] str = {"d","b","c","b","c","a"};
        int k =2;
        System.out.println(kthDistinct(str, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int x = hm.getOrDefault(arr[i], 0);
            hm.put(arr[i], x+1);
        }
        String result = "";
        for (String a : arr) {
            if(hm.get(a) == 1) {
                k--;
            }
            if (k==0) return a;
        }
        return result;
    }
}
