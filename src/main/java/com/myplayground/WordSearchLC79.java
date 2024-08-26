package com.myplayground;

/**
 * Time complexity
 * row * col * 4 power length of string ~ = 4powern
 */
public class WordSearchLC79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (check(board, word, i, j, 0, visited)) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }

    public static boolean check(char[][] board, String word, int row, int col, int idx, boolean[][] visited) {
        if (word.length() == idx) return true;

        if (row == board.length || col == board[0].length || row < 0 || col < 0 || word.charAt(idx) != board[row][col] || visited[row][col]) return false;

        visited[row][col] = true;
        boolean result = (check(board, word, row+1, col, idx+1, visited) ||
                        check(board, word, row, col+1, idx+1, visited) ||
                        check(board, word, row-1, col, idx+1, visited) ||
                        check(board, word, row, col-1, idx+1, visited) );
        visited[row][col] = false;
        return result;
    }
}