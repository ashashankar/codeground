package com.myplayground.playground;

import java.util.ArrayList;
import java.util.HashSet;

public class kthLexiographicallyHappyStringLC1415 {
    char[] letters = {'a', 'b', 'c'};
    static int len = 0;
    public static void main(String[] args) {
        int n = 3;
        len = n;
        int k = 9;
        new kthLexiographicallyHappyStringLC1415().construct(new StringBuilder(), 0);
        System.out.println(patterns);
        if (k > patterns.size())  {
            System.out.println("k is larger. Empty String");

        } else {
            System.out.println(patterns.get(k-1));
        }

    }
    static HashSet<String> used = new HashSet<>();
    static ArrayList<String> patterns = new ArrayList<>();
    public void construct(StringBuilder sb, int index) {
        if (index == len) {
            used.add(sb.toString());
            patterns.add(sb.toString());
            return;
        }
        for (int i=0; i<letters.length; i++) {
            char str = letters[i];
            if (index-1 >= 0 && str == sb.charAt(index -1)) continue;
            if (used.contains(sb.toString())) continue;
            sb.append(str);
            construct(sb, index+1);
            sb.deleteCharAt(index);
        }
    }
}
