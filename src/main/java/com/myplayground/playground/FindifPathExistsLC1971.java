package com.myplayground.playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindifPathExistsLC1971 {
    public static void main(String[] args) {
        int n= 10;
        int [][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        int source = 5;
        int destination = 9;
        System.out.println( validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i=0; i<edges.length; i++) {
            int node = edges[i][0];
            int edge = edges[i][1];
            adj.get(node).add(edge);
            adj.get(edge).add(node);
        }

        Queue<Integer> q = new LinkedList();
        q.offer(source);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int s = q.poll();
            if (!visited[s]) {
                for (int i=0; i<adj.get(s).size(); i++) {
                    q.offer(adj.get(s).get(i));

                }
                visited[s] = true;
            }
        }

        return visited[destination];
    }
}

