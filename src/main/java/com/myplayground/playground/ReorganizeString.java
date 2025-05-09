package com.myplayground.playground;

import java.util.Arrays;

/**
 *
 * ReorganizeString such that no two characters are the same.
 */
public class ReorganizeString {
    public static void main(String[] args) {
        String s = "wfndrin";//

        int[] hash = new int[26];
        for (int i=0; i< s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int freq = (s.length()+1)/2;
        int majorityElement=0;
        int mFreq=0;
        for (int j=0; j<hash.length; j++) {
            if (hash[j] > mFreq) {
                majorityElement = j +'a';
                mFreq = hash[j];
            }
        }

        if (mFreq > freq) {
            System.out.println(" NO REORDER, return empty");
           // System.exit(1);

        }
        char[] result = new char[s.length()];
        int idx = 0;
        while (hash[majorityElement-'a']-- > 0) {
            result[idx] = (char)majorityElement;
            idx += 2;
        }

       // idx = 1;
        for (int k=0; k< hash.length; k++) {
            while (hash[k] > 0) {
               // if (idx >= s.length()) idx=s.length()-1;
                if(idx >= s.length()) idx = 1;
                result[idx] = (char)(k + 'a');
                idx += 2;
                hash[k]--;
            }
        }

        System.out.println(String.valueOf(result));


    }
}
