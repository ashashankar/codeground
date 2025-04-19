package com.myplayground.playground;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    public static String solve(int A) {

        if (A == 1)
            return "11";
        else if (A == 2)
            return "22";

        Queue<String> q = new LinkedList();
        q.add("1");
        q.add("2");
        int count = 0;
        String result = null;
        while (count <= A+1) {
            String pattern = q.poll();
            StringBuilder sbone = new StringBuilder(pattern);
            sbone.append("1");
            q.add(sbone.toString());
            count++;

            if (count == A) {
                result = q.peek();
            }


            StringBuilder sbtwo  = new StringBuilder(pattern);
            sbtwo.append("2");
            q.add(sbtwo.toString());
            count++;

            if (count == A) {
                result = q.peek();
            }

        }
        StringBuilder sresult = new StringBuilder(result);
        sresult.append(sresult.reverse());
        return sresult.toString();
    }
}
