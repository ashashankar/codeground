package com.myplayground.playground;

import java.util.HashMap;

public class LetterTilePossibilitiesLC1079 {
    public static void main(String[] args) {
        String input = "AAC";
        new LetterTilePossibilitiesLC1079().numTilePossibilities(input);
    }

    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i=0; i<tiles.length(); i++) {
            char ch = tiles.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        //int count = buildString(hm);
        int count = printString(hm, new StringBuilder());
        return count;
    }

    public int buildString(HashMap<Character, Integer> hm ) {
        int ways = 0;
        for (int i=0; i<26; i++) {
            char ch = (char) (i + 'A');

            if(!hm.containsKey(ch)) continue;
            if (hm.get(ch) == 0) continue;
            hm.put(ch, hm.get(ch)-1);
            ways += 1 + buildString(hm);
            hm.put(ch, hm.get(ch)+1);
        }
        return ways;
    }

    public int printString(HashMap<Character, Integer> hm, StringBuilder sb ) {
        int ways = 0;

        for (int i=0; i<26; i++) {
            char ch = (char) (i + 'A');

            if(!hm.containsKey(ch)) continue;
            if (hm.get(ch) == 0) continue;
            sb.append(ch);
            hm.put(ch, hm.get(ch)-1);
            ways += 1 + printString(hm, sb);
            System.out.println(sb.toString());
            int index = sb.lastIndexOf(ch+"");
            sb.deleteCharAt(index);
            hm.put(ch, hm.get(ch)+1);
        }
        return ways;
    }
}
