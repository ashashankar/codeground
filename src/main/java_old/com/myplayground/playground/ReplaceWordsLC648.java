package com.myplayground.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReplaceWordsLC648 {

    public  static void main(String[] args) {
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("aa");
        words.add("aaa");
        words.add("aaaa");
        String s = new ReplaceWordsLC648().replaceWords(words, sentence);
        System.out.println(s);
    }
    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {

        for (String s: dictionary) {
            insert(s);
        }
        String[] arr = sentence.split(" ");
        for (int i=0; i<arr.length; i++) {
            String pre = getPrefix(arr[i]);
            System.out.println(pre);
            arr[i] = pre;
        }

        StringBuilder sb = new StringBuilder();
        for (int j=0; j<arr.length; j++) {
            sb.append(arr[j]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public void insert(String s) {
        TrieNode curr = root;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!curr.hm.containsKey(ch)) {
                TrieNode node = new TrieNode();
                curr.hm.put(ch, node);
            }
            curr = curr.hm.get(ch);
        }
        curr.isEnd = true;
    }

    public String getPrefix(String s) {
        TrieNode curr = root;
        int j =0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (!curr.hm.containsKey(ch)) {
                return s;
            } else if (curr.hm.get(ch).isEnd) {
                return s.substring(0, j+1);
            }
            j++;
            curr = curr.hm.get(ch);

        }
        System.out.println(s.substring(0, j));
        return s.substring(0, j);

    }
}

class TrieNode {
    boolean isEnd = false;
    HashMap<Character, TrieNode> hm = new HashMap();

}