package com.myplayground.playground;

import java.util.LinkedList;
import java.util.Queue;

public class CountAndSayLC38 {

    public static void main(String[] args) {
        String input = "11";
        int c = 4;

        for (int i=0; i<c; i++) {
            input = bf(input, c);
        }
        System.out.println(input);
    }


    public static String bf(String input, int num){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()){
            char ch = input.charAt(i);
            int k = i;
            while (k+1 < input.length() && input.charAt(k+1) == input.charAt(k)) {
                k++;
            }
            if (k == 0) {
                sb.append(1).append(ch);
            } else {
                sb.append(k-i+1).append(ch);
                i = k;
            }
            i++;
            if (k+1 == input.length()) break;
        }
        return  sb.toString();
    }
}
