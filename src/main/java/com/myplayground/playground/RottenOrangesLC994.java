import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesLC994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new RottenOrangesLC994().bfs(grid));
    }

    public int bfs(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int time = 0;
        int freshOranges = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] ==2) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Pair p = q.poll();
                int r = p.getR();
                int c = p.getC();
                for (int[] d : dirs) {
                    int rr = r + d[0];
                    int cc = c + d[1];
                    if (rr >= rows || cc >= cols || rr < 0 || cc < 0 || grid[rr][cc] != 1) continue;
                    if (grid[rr][cc] == 1) {
                        grid[rr][cc] = 2;
                        freshOranges--;
                        q.offer(new Pair(rr, cc));
                    }
                }
            }
            time += 1;
        }

        return time;
    }

}

class Pair {
    int r;
    int c;
    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
    public int getR() {
        return this.r;
    }
    public int getC() {
        return this.c;
    }
}