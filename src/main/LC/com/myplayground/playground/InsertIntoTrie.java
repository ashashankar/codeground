package com.myplayground.playground;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsertIntoTrie {
    static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        A.add(0);
        A.add(0);
        A.add(1);
        A.add(1);
        B.add("hack");
        B.add("hacker");
        B.add("hack");
        B.add("hak");
        ArrayList<Integer> result = new ArrayList();
        for (int i=0; i<A.size(); i++) {
            if (A.get(i) == 0) {
                new InsertIntoTrie().insert(B.get(i));
            } else {
                int x = new InsertIntoTrie().searchPrfix(B.get(i));
                result.add(x);
            }
        }
        System.out.println(result);

    }
    public void insert(String str) {
        TrieNode curr = root;
        int len = str.length();
        for (int i=0; i<len; i++) {
            char ch = str.charAt(i);
            if (!curr.hm.containsKey(ch)) {
                TrieNode node = new TrieNode();
                curr.hm.put(ch, node);
            }
            curr.count = curr.count +1;
            curr = curr.hm.get(ch);
        }
        curr.isEnd = true;
    }

    public int searchPrfix(String str) {
        TrieNode curr = root;
        int len = str.length();
        for (int i=0; i<len; i++) {
            char ch = str.charAt(i);
            if (!curr.hm.containsKey(ch)) {
                return 0;
            }

            curr = curr.hm.get(ch);
        }
        return curr.count;
    }
}


@Getter
class TrieNode {
    int count;
    HashMap<Character, TrieNode> hm = new HashMap<>();
    boolean isEnd;
    TrieNode() {
    }
}
