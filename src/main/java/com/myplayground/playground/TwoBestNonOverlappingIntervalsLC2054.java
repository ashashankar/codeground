package com.myplayground.playground;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingIntervalsLC2054 {
    public static void main(String[] args) {
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}, {12,14,13}};
        System.out.println(new TwoBestNonOverlappingIntervalsLC2054().maxTwoEvents(events));
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, ((a, b) -> a[0]- b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int prevMax = 0;
        int result = 0;
        for (int[] e : events) {
            while (!pq.isEmpty() && pq.peek()[1] < e[0]) {
                prevMax = Math.max(pq.peek()[2], prevMax);
                pq.poll();
            }
            pq.offer(e);
            result = Math.max(result , prevMax + e[2]);
        }

        return result;
    }
}
