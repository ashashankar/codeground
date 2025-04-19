package com.myplayground.playground;

import java.util.*;
import java.util.stream.Collectors;

public class UglyNumberIILC264 {
    public static void main(String[] args) {
        int n = 12;
        //long answer = uglyNum(n);
        //System.out.println(answer);

        int answer = nthUglyNumber(n);
        System.out.println(answer);


    }

    /**
     * nlogn time
     * n space
     * @param n
     * @return
     */
    private static long uglyNum(int n ) {
        HashSet<Long> hs = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[] factors =  {2, 3, 5};
        pq.add(1l);
        int i = 1;
        while (i<n) {
            long ele = pq.poll();
            for (int k: factors) {
                long num = k * ele;
                if (!hs.contains(num)) {
                    pq.add(num);
                    hs.add(num);
                }
            }
            i++;
        }
        return pq.peek();
    }

    public static int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int t2 = 0, t3 = 0, t5 = 0;
        int[] k = new int[n];
        k[0] = 1;

        for (int i = 1; i < n; i++) {
            k[i] = Math.min(k[t2] * 2, Math.min(k[t3] * 3, k[t5] * 5));

            if (k[i] == k[t2] * 2) t2++;
            if (k[i] == k[t3] * 3) t3++;
            if (k[i] == k[t5] * 5) t5++;
        }

        return k[n - 1];
    }
}
