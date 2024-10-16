package com.myplayground.playground;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import com.myplayground.playground.Pair;

public class LongestHappyStringLC1405 {
    public static void main(String[] args) {
        System.out.println(new LongestHappyStringLC1405().longestDiverseString(1, 1, 7));
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> largeQ = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(Pair::getValue)));

        Pair pair = null;
        if (a != 0) {
            pair = new Pair("a", a);
            largeQ.add(pair);
        }
        if (b != 0) {
            pair = new Pair("b", b);
            largeQ.add(pair);
        }
        if (c != 0) {
            pair = new Pair("c", c);
            largeQ.add(pair);
        }




        StringBuilder answer = new StringBuilder();
        while (!largeQ.isEmpty()) {
            Pair p = largeQ.poll();
            int count = p.getValue();
            char[] ch = p.getName().toCharArray();
            if (answer.length()>1 && answer.charAt(answer.length()-1) == ch[0] && answer.charAt(answer.length()-2) == ch[0]) {
                if (largeQ.isEmpty()) break;
                Pair p2 = largeQ.poll();
                int count2 = p2.getValue();
                answer.append(p2.getName());
                count2 -= 1;
                if (count2 > 0)
                    largeQ.add(new Pair(p2.getName(), count2));

            } else {
                answer.append(p.getName());
                count -= 1;
            }

            if (count > 0) {
                largeQ.add(new Pair(p.getName(), count));
            }
        }
        return answer.toString();

    }
}
