package com.myplayground.playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void BFS(ArrayList<ArrayList<Integer>> m, int p) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        int max = 100;
        for (int i=0; i<max; i++) {
            adj.add(new ArrayList<>());
            visited.add(false);
        }
        for (ArrayList<Integer> edge : m) {
           adj.get(edge.get(0)).add(edge.get(1));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited.set(1, true);
        while (!q.isEmpty()) {
            int x = q.poll();
            for(int r=0; r<adj.get(x).size(); r++) {
                int node = adj.get(x).get(r);
                if(!visited.get(node)) {
                    visited.set(r, true);
                    q.add(node);
                }
            }
        }
        System.out.println(" Path Exists "+ visited.get(p));
    }
}
