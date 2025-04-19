package com.myplayground.playground;

import java.util.*;

public class SlidingPuzzleLC773 {
    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {5, 4, 0}};
        int swaps = new SlidingPuzzleLC773().slidingPuzzle(board);
        System.out.println(swaps);
    }

    public int slidingPuzzle(int[][] board) {
        ArrayList<int[]> adj = new ArrayList<>();
        adj.add(new int[]{1, 3});
        adj.add(new int[]{0, 2, 4});
        adj.add(new int[]{1, 5});
        adj.add(new int[]{0, 4});
        adj.add(new int[]{1, 3, 5});
        adj.add(new int[]{2, 4});

        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String result = "123450";
        visited.add(sb.toString());
        int levels = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(sb.toString());
        q.offer(null);
        while (!q.isEmpty() && q.size() > 1) {
            String s = q.poll();
            if (s == null) {
                levels++;
                q.offer(null);
            } else {
                if (s.equals(result)) return levels;
                int pos = s.indexOf("0");
                int[] dir = adj.get(pos);
                for (int i=0; i<dir.length; i++) {
                    int d = dir[i];
                    String new_str = swap(s, pos, d);
                    if (!visited.contains(new_str)) {
                        visited.add(new_str);
                        q.offer(new_str);
                    }
                }
            }

        }
        return -1;
    }

    public String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
