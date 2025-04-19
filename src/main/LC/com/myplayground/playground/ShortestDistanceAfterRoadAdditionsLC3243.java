package com.myplayground.playground;


import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestDistanceAfterRoadAdditionsLC3243 {
    public static void main(String[] args) {
        int[][] queries = {{2,4},{1,4}}; //{{2,4},{0,2},{0,4}};
        int n = 5;


        int [] times = new ShortestDistanceAfterRoadAdditionsLC3243().shortestDistanceAfterQueries(n, queries);
        System.out.println(Arrays.toString(times));
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<PPair>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            adj.get(i).add(new PPair(1, i+1));
        }

        int[] times = new int[n];
        Arrays.fill(times, (int)1e9);
        times[0] = 0;
        int[] result = new int[queries.length];
        int i= 0;
        for (int[] q: queries) {
            adj.get(q[0]).add(new PPair(1, q[1]));
            bfs(times, adj);
            result[i] = times[times.length-1];
            i++;
        }
        return result;
    }

    public void bfs(int[] times, ArrayList<ArrayList<PPair>> adj) {
        PriorityQueue<PPair> pq = new PriorityQueue<>(Comparator.comparingInt(PPair::getWeight));
        pq.offer(new PPair(0, 0));
        while (!pq.isEmpty()) {
            PPair p = pq.poll();
            int w = p.getWeight();
            int dest = p.getNode();
            for (int i=0; i<adj.get(dest).size(); i++) {
                PPair pr = adj.get(dest).get(i);

                int weight = pr.getWeight();
                int destination = pr.getNode();
                if(weight + w <= times[destination]) {
                    times[destination] = weight+w;
                    pq.add(new PPair( weight+w, destination));
                }
            }

        }
    }
}
