package com.myplayground.playground;

public class CountUnguardedCellsLC2257 {
    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}};;
        int[][] walls = {{0,1},{2,2},{1,4}};
        int answer = new CountUnguardedCellsLC2257().countUnguarded(m, n, guards, walls);
        System.out.println(answer);
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];

        int result = 0;
        for (int[] w : walls) {
            int r = w[0];
            int c = w[1];
            matrix[r][c] = -1;
        }

        for (int[] g : guards) {
            int r = g[0];
            int c = g[1];
            matrix[r][c] = -2;
            dfs(matrix, r+1, c , matrix.length, matrix[0].length,  'D');
            dfs(matrix, r-1, c , matrix.length, matrix[0].length, 'U');
            dfs(matrix, r, c+1 , matrix.length, matrix[0].length,  'R');
            dfs(matrix, r, c-1 , matrix.length, matrix[0].length,  'L');
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == -2) {
                   // dfs(matrix, i, j , matrix.length, matrix[0].length, visited);

                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) result++;
            }
        }
        return result;
    }

    public void dfs(int[][] matrix, int i, int j, int r, int c,  char ch) {
        if (i<0 || i==r || j<0 || j== c || matrix[i][j] == -1 || matrix[i][j] == -2) {
            return;
        }
        matrix[i][j] = -3;

        if (ch ==  'U') {
            dfs(matrix, i-1, j , matrix.length, matrix[0].length, 'U');
        } else if (ch == 'D') {
            dfs(matrix, i+1, j , matrix.length, matrix[0].length,'D');
        }  else if (ch == 'R') {
            dfs(matrix, i, j+1 , matrix.length, matrix[0].length,  'R');
        }  else if (ch == 'L') {
            dfs(matrix, i, j-1 , matrix.length, matrix[0].length, 'L');
        }

    }
}
