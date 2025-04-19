package com.myplayground.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AMZNRegionServersInclusive {
    public static void main(String[] args) {
        int[] regionStart = {1, 2, 4, 10};
        int[] regionEnd = {5, 6, 8, 12};
        System.out.println(minRetailersToRelocate(Arrays.stream(regionStart).boxed().toList(), Arrays.stream(regionEnd).boxed().toList()));

    }

    public static int minRetailersToRelocate(List<Integer> regionStart, List<Integer> regionEnd) {
        int len = regionStart.size();
        List<int[]> regions = new ArrayList<>();
        for (int i=0; i<len; i++) {
            int[] r = new int[2];
            r[0] = regionStart.get(i);
            r[1] = regionEnd.get(i);
            regions.add(r);
        }
        Collections.sort(regions, (a, b)-> a[0] - b[0]);
        int overlap_regions = 0;
        int r_end = regions.get(0)[1];
        for (int i=1; i<regions.size(); i++) {
            if (regions.get(i)[0] < r_end) {
                overlap_regions++;
                r_end = Math.max(r_end, regions.get(i)[1]);
            } else {
                r_end = regions.get(i)[1];
            }
        }

        return len - overlap_regions;
    }
}
