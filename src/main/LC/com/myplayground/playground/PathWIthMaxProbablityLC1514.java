package com.myplayground.playground;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWIthMaxProbablityLC1514 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] probs = {0.5,0.5,0.3};
        int start = 0;
        int end = 2;

        findPath(n, edges, probs, start, end);
    }

    public static double findPath(int n, int[][] edges, double[] probs, int start, int end)  {

        ArrayList<ArrayList<pw>> adj = createAdjList(n, edges, probs);
        System.out.println(adj);

        PriorityQueue<pw> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingDouble(pw::getWeight)));
        pq.add(new pw(start, 1));
        boolean[] visited = new boolean[n+1];

        while (!pq.isEmpty()) {
            pw current = pq.poll();
            visited[current.destination] = true;
            if (current.destination == end) {
                System.out.println("arrived to desitnation. Weight " + current.weight);
                return current.weight;
            }
            for (pw neighbour : adj.get(current.destination)) {
                if (!visited[neighbour.destination])   {
                    pq.add(new pw(neighbour.destination, (neighbour.weight * current.weight)));
                }
            }

        }
        return 0;
    }

    public static ArrayList<ArrayList<pw>> createAdjList(int n, int[][] edges, double[] probs) {
        ArrayList<ArrayList<pw>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int[] arr = edges[i];
            double w = probs[i];
            adj.get(arr[0]).add(new pw(arr[1],w));
            adj.get(arr[1]).add(new pw(arr[0], w));
        }
        return  adj;
    }
}

@Getter
@Setter
class pw {
    int destination;
    double weight;

    public pw(int dest, double w) {
        this.destination = dest;
        this.weight = w;
    }

    @Override
    public String toString() {
        String s = "destination " + destination + " weight " + weight;
        return s;
    }
}
