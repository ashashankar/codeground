package com.myplayground.playground;

import java.util.HashSet;
import java.util.Iterator;

public class LongestCommonPrefixLC3043 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};//{1,10,1001};
        int[] arr2 = {4,4,4};//{1001};
        System.out.println(new LongestCommonPrefixLC3043().getLCP(arr1, arr2));
    }

    public int getLCP(int[] arr1, int[] arr2) {
        int len = 0;
        String[] str1 = new String[arr1.length];
        String[] str2 = new String[arr2.length];

        for (int i=0; i<arr1.length; i++) {
            str1[i] = String.valueOf(arr1[i]);
        }

        for (int i=0; i<arr2.length; i++) {
            str2[i] = String.valueOf(arr2[i]);
        }

        HashSet<String> str2Prefix = new HashSet<>();
        HashSet<String> str1Prefix = new HashSet<>();
        for (String str : str2) {
            int i=str.length();

            while(i > 0) {
                String word = str.substring(0, i);
                str2Prefix.add(word);
                i--;
            }
        }

        for (String str : str1) {
            int i=str.length();

            while(i > 0) {
                String word = str.substring(0, i);
                str1Prefix.add(word);
                i--;
            }
        }
        Iterator<String>  it = str1Prefix.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (str2Prefix.contains(s)) {
                len = Math.max(len, s.length());
            }
        }

        return len;
    }
}
