package com.myplayground.playground;

import java.util.ArrayList;
import java.util.Arrays;

public class CarPoolingLC1094 {
    public static void main(String[] args) {
        int[][] test =
                {
                        {2, 1, 5},
                        {3, 5, 7}
                };
        new CarPoolingLC1094().carPooling(test, 3);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] routes = new int[1001];
        for (int i=0; i<trips.length; i++) {
            int persons = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            routes[start]+= persons;
            routes[end] -= persons;
        }
        int count = 0;
        for (int j=0; j<routes.length; j++) {
            count += routes[j];
            if (count > capacity) return false;
        }
        return true;
    }
}
