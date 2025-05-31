package codeground.src.main.java.com.myplayground.playground;

public class Anagram {

    public static void main(String[] args) {
        String s  = "a";
        String b = "ab";
        System.out.println(isAnagram(s, b));
    }

    public static boolean isAnagram(String s, String t) {
        int[] countArr = new int[26];
        for (char c : s.toCharArray()) {
            countArr[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            countArr[c - 'a'] --;
        }

        for (int i : countArr) {
            if (i != 0) return false;
        }
        return true;
    }

}
