package com.myplayground.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import com.myplayground.playground.Pair;
import lombok.Getter;
import lombok.Setter;

public class NetworkDelayTimeDjikstra {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};// {{1,2,1},{2,3,2},{1,3,1}};//{{1,2,1}};//{{1,2,1}, {2,1,3}};//{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        int time = networkDelayTime(times ,n, k);
        System.out.println(time);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int result = -1;
        ArrayList<ArrayList<Pair>> adj = getAdjList(times, n+1);

        int[] minPath = new int[n+1];
        Arrays.fill(minPath, (int)1e9);

        minPath[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getNumber));
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.idx;
            int weight = pair.number;

            for (Pair ps : adj.get(node)) {
                int edgeWeight = ps.getNumber();
                int edgeNode = ps.idx;
                if (weight + edgeWeight < minPath[edgeNode]) {
                    minPath[edgeNode] = weight + edgeWeight;
                    pq.add(new Pair(edgeNode, minPath[edgeNode]));
                }
            }
        }
        System.out.println(Arrays.toString(minPath));
        for (int i=1; i<minPath.length; i++) {
            if (minPath[i] != (int)1e9) {
                result = Math.max(result, minPath[i]);
            }
        }

        for (int i=1; i<minPath.length; i++) {
            if(i == 0) continue;
            if (minPath[i] == (int) 1e9) {
                result = -1;
                break;
            }
        }
        return (result == 0)? -1 : result;
    }

    public static ArrayList<ArrayList<Pair>> getAdjList(int[][] times, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int[] child : times) {
            adj.get(child[0]).add(new Pair(child[1], child[2]));
        }

        return adj;
    }
}

@Getter
@Setter
class Pair {
    int idx;
    int number;
    Pair (int i, int num) {
        this.idx = i;
        this.number = num;
    }
}