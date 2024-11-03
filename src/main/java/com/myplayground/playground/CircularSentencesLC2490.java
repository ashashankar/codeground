package com.myplayground.playground;

public class CircularSentencesLC2490 {
    public static void main(String[] args) {
        String s = "leetcode exercises sound delightful";
        System.out.println(new CircularSentencesLC2490().isCircular(s));
    }

    public boolean isCircular(String str) {
        String[] sentence = str.split(" ");
        String s1 = sentence[0];
        String slast = sentence[sentence.length-1];
        if (s1.charAt(0) != slast.charAt(slast.length()-1)) return false;
        char ch = sentence[0].charAt(sentence[0].length()-1);
        for (int i=1; i<sentence.length; i++) {
            String s = sentence[i];

            if (ch != s.charAt(0)) return false;
            ch = s.charAt(s.length()-1);
        }
        return true;
    }
}
