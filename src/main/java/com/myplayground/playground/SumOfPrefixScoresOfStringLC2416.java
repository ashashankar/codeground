package com.myplayground.playground;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class SumOfPrefixScoresOfStringLC2416 {
    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};
        for (String s : words)
            new SumOfPrefixScoresOfStringLC2416().insert(s);

        for (String s : words) {
            System.out.println(new SumOfPrefixScoresOfStringLC2416().getPrefixCount(s));
        }
    }
   static Trie root = new Trie();
    public void insert(String s) {
        Trie curr = root;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (!curr.getMap().containsKey(ch)) {
                Trie node = new Trie();
                curr.getMap().put(ch, node);
            }
            curr.getMap().get(ch).count = curr.getMap().get(ch).getCount() + 1;
            curr = curr.map.get(ch);
        }
        curr.isEnd = true;
    }

    public int getPrefixCount(String s) {
        Trie curr = root;
        int c = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            c += curr.getMap().get(ch).getCount();
            curr = curr.getMap().get(ch);
        }
        return c;
    }
}


@Getter
@Setter
class Trie {
    int count;
    boolean isEnd;
    HashMap<Character, Trie> map = new HashMap<>();
}