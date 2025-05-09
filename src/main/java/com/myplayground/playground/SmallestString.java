package com.myplayground.playground;

public class SmallestString {
    public static void main(String[] args) {
        String str = "bbcacad";
        int i = 0;
        int j = 1;
        while (j < str.length()) {
            if (str.charAt(i) > str.charAt(j)) {
                String s = swap(str, i, j);
                str = s;
                i++;
                j++;
            } else {
                j++;
            }
        }
        System.out.println(str);
    }

    public static String swap(String s, int i, int j) {
        char c1 = s.charAt(i);
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.setCharAt(i, s.charAt(j));
        stringBuilder.setCharAt(j, c1);
        return stringBuilder.toString();
    }
}
