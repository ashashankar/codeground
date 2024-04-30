package com.myplayground.playground;

/**
 * Input: s1 = "parker", s2 = "morris", baseStr = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
 * The characters in each group are equivalent and sorted in lexicographical order.
 * So the answer is "makkek".
 */
public class LexicographycallySmallestEquivalent {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String baseStr = "hold";
        UnionFind uf = new UnionFind();
        for (int i=0; i< s1.length(); i++) {
            uf.union(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<baseStr.length(); j++) {
            char ch = (char)(uf.find(baseStr.charAt(j)) + 'a');
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}


class UnionFind {
    int[] ids = new int[26];
    UnionFind() {
        for (int i=0; i<26; i++) {
            ids[i] = i;
        }
    }

    public void union(char a , char b) {
        int x = find(a);
        int y = find(b);
        if (x > y) {
            ids[x] = y;
        } else {
            ids[y] =x;
        }
    }

    public int find(char c) {
        if (ids[c-'a'] != c - 'a') {
            ids[c - 'a'] = ids[ids[c - 'a']];
            c = (char) (ids[c-'a'] + 'a');
        }
        return ids[c - 'a'];
    }
}