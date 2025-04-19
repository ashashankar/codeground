package com.myplayground.playground;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class FlipCardMaximizeProfit_SC {

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 3, 3};
        int[] B = {5, 6, 1, 3, 9};

        System.out.println(new FlipCardMaximizeProfit_SC().solve(A, B));
    }

    public int solve(int[] A, int[] B) {
        ArrayList<ArrayList<Integer>> deadlines = new ArrayList();
        long mod = 1000000007;
        for (int l=0; l<A.length; l++) {
            ArrayList<Integer> p = new ArrayList<>();
            p.add(A[l]);
            p.add(B[l]);
            deadlines.add(p);
        }
        deadlines.sort(Comparator.comparingInt(d -> d.get(0)));
        long totalProfit = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        int time = 0;
        for (int i=0; i<deadlines.size(); i++) {
            int d = deadlines.get(i).get(0);
            int profit = deadlines.get(i).get(1);
            if (time <= d-1) {
                totalProfit = (totalProfit + profit)%mod;
                time++;
                pq.offer(profit);
            } else {
                // check to swap for
                if (!pq.isEmpty() && profit > pq.peek()) {
                    int pqProfit = pq.poll();
                    totalProfit -= pqProfit;
                    totalProfit = (totalProfit + profit)%mod;
                    pq.offer(profit);

                }
            }
        }

        return (int)(totalProfit%mod);
    }
}
