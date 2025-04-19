package com.myplayground.playground;

/**
 * Find number of occurrences of common characters
 */
public class CommonCharacters {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";
        System.out.println(solution(s1, s2));
    }

    public static int solution(String s1, String s2) {
        int[] str1 = new int[26];
        int[] str2 = new int[26];

        for (int i=0; i<s1.length(); i++) {
            str1[s1.charAt(i)-'a']++;
        }


        for (int j=0; j<s2.length(); j++) {
            str2[s2.charAt(j)-'a']++;
        }
        int count = 0;
        for (int k=0; k<26; k++){
            if (str1[k] > 0 && str2[k] > 0) {
                count += Math.min(str1[k], str2[k]);
            }
        }
        return count;
    }

}
