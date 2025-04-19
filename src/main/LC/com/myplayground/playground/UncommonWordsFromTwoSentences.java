package com.myplayground.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * LC884 Weekly contest
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 =  "this apple is sour";
        new UncommonWordsFromTwoSentences().uncommonFromSentences(s1, s2);
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> uncommonStrings = new ArrayList<>();
        String[] sone = s1.split(" ");
        String[] stwo = s2.split(" ");
        for (String s : sone) {
            hm.put(s, hm.getOrDefault(s, 0) +1);
        }

        for (String s: stwo) {
            if (!hm.containsKey(s)) {
                hm.put(s,1);
            } else {
                hm.put(s, hm.get(s)  +11);
            }
        }

        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (e.getValue() == 1) uncommonStrings.add(e.getKey());
        }
        return uncommonStrings.toArray(new String[uncommonStrings.size()]);
    }
}
