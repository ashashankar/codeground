package com.myplayground.playground;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.*;

public class MinimumObstacleToRemoveLC2290 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,1,0},{1,1,0}}; //;{{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}}; //
        new MinimumObstacleToRemoveLC2290().minimumObstacles(grid);
    }

    public int minimumObstacles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int r_start = r-1;
        int c_start = c-1;
        int[][] visited = new int[r][c];
        int answer = bfs(r_start, c_start, r, c, grid, visited);
        System.out.println(answer);
        return answer;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int bfs(int i, int j, int r, int c, int[][] grid,  int[][] visited) {
        Queue<PPair> pq = new PriorityQueue<>(Comparator.comparingInt(PPair::getWeight));
        pq.offer(new PPair(0, 0, 0));
        visited[0][0] = 1;
        int answer = 0;
        while (!pq.isEmpty()) {
            PPair pair = pq.poll();
            int weight = pair.getW();
            int row = pair.getR();
            int col = pair.getC();
            if (row == r-1 && col == c-1)  {
               answer = weight;
                break;
            }
            for (int[] arr : dirs) {
                int rw = row + arr[0];
                int cl = col + arr[1];
                if (rw <0 || rw == r || cl < 0 || cl == c) continue;

                if (visited[rw][cl] == 1) continue;
                visited[rw][cl] = 1;
                pq.offer(new PPair(weight + grid[rw][cl], rw, cl));
            }
        }
        return answer;
    }

    public int bfsDequeuApproach(int r, int c, int[][] grid,  int[][] visited) {
        Deque<PPair> pq =  new LinkedList<>();
        pq.offerFirst(new PPair(0, 0, 0));
        visited[0][0] = 1;
        int answer = 0;
        while (!pq.isEmpty()) {
            PPair pair = pq.pollFirst();
            int weight = pair.getW();
            int row = pair.getR();
            int col = pair.getC();
            if (row == r-1 && col == c-1)  {
                answer = weight;
                break;
            }
            for (int[] arr : dirs) {
                int rw = row + arr[0];
                int cl = col + arr[1];
                if (rw <0 || rw == r || cl < 0 || cl == c) continue;

                if (visited[rw][cl] == 1) continue;
                if (grid[rw][cl] == 1) {
                    pq.offerLast(new PPair(weight + grid[rw][cl], rw, cl));
                } else {
                    pq.offerFirst(new PPair(weight + grid[rw][cl], rw, cl));
                }

                visited[rw][cl] = 1;

            }
        }
        return answer;
    }
}
