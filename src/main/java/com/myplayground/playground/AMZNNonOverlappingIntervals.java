package com.myplayground.playground;

import java.util.Arrays;

public class AMZNNonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {1, 3}, {2, 5}, {3, 4}, {4, 5}};
        eraseOverlapIntervals(intervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
