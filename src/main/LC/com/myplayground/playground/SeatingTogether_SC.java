package com.myplayground.playground;

import java.util.ArrayList;

public class SeatingTogether_SC {
    int MOD = 10000003;
    public static void main (String[] args) {
        String s = "....x..xx...x..";
        System.out.println(new SeatingTogether_SC().minMoves(s));
    }

    public int minMoves(String A) {
        int n = A.length();
        int ans = 0;
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(A.charAt(i) == 'x') {
                people.add(i);
            }
        }
        if(people.size()==0)
            return 0;
        int len = people.size();
        int median = len/2;
        int left  = median -1;
        int right = median + 1;
        int k = 1;
        int result = 0;
        if (people.size() == 0) return 0;
        while (left >= 0) {

            result += people.get(median) - people.get(left)-k;
            k++;

            left--;

        }
        k = 1;
        while (right < len) {
            result += people.get(median) - (people.get(right)+k);
            k++;
            right++;

        }
        return result%MOD;
    }
    public int BruteForceminMoves(char[] seats) {
        int n = seats.length;

        // step 1. count people
        int k = 0;
        for (int i = 0; i < n; i++)
        {
            if (seats[i] == 'x') {
                k++;
            }
        }

        // step 2. move the window of size k and count the hops
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n - k; j++) {
            int hops = 0, p = j;

            for (int i = 0; i < n; i++) {
                if (seats[i] == 'x') {
                    hops += Math.abs(i - p++);
                }
            }

            min = Math.min(min, hops);
        }

        return min;
    }
}
