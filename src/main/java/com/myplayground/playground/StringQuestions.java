package com.myplayground.playground;

public class StringQuestions {
    public static void main(String[] args) {
        String s = "leetcode exercises sound delightful";
        //System.out.println(new CircularSentencesLC2490().isCircular(s));
        s = "aaabaaaa";
        System.out.println(new StringQuestions().makeFancyStringLC1957(s));
    }

    public boolean isCircularLC2490(String str) {
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


    public String makeFancyStringLC1957(String s) {
        char[] ch = s.toCharArray();
        int c = 0;
        for (int i=1; i<ch.length; i++) {
            if (ch[i] == ch[i-1]) {
                c++;
            } else {
                c = 0;
            }
            if (c >= 2) {
                ch[i] = ' ';
                c--;
            }
        }

        String str = new String(ch);
        return str.replaceAll("\\s+", "");

    }
}
