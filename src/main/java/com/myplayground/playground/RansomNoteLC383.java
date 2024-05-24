package com.myplayground.playground;
import java.util.*;
public class RansomNoteLC383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
    public static  boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> frequency = new HashMap();
        for (int i=0; i<ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            frequency.put(ch , frequency.getOrDefault(ch, 0)+1);
        }

        for (int j=0; j<magazine.length(); j++) {
            char ch = magazine.charAt(j);
            if (!frequency.containsKey(ch)) {
                return false;
            } else {
                int freq = frequency.get(ch);
                freq = freq -1 ;
                frequency.put(ch, freq);
                if (freq == 0) frequency.remove(ch);

            }
        }
        return true;
    }
}
