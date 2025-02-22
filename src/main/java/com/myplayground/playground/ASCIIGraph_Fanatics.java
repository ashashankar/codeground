package com.myplayground.playground;

public class ASCIIGraph_Fanatics {
    public static void main(String[] args) {
        int maxX = 5;
        int maxY = 8;
        int[][] data = {{1, 2}, {2, 3}, {3, 1}, {4, 6}, {5, 8}};
        char[][] grid = new char[maxX + 2][maxY + 2];

        // Initialize the grid with empty spaces
        for (int i = 0; i < maxX + 2; i++) {
            for (int y = 0; y < maxY + 2; y++) {
                grid[i][y] = ' ';
            }
        }

        // Plot the data points on the grid
        for (int[] data_point : data) {
            int row = data_point[0]; // X-coordinate
            int col = data_point[1]; // Y-coordinate
            grid[maxX - row + 1][col] = '*'; // Invert Y-axis and adjust for grid
        }

        // Draw the vertical borders
        for (int i = 0; i < maxX + 2; i++) {
            grid[i][0] = '+'; // Left border
            grid[i][maxY + 1] = '+'; // Right border
        }

        // Draw the segmented horizontal top border
        for (int i = 0; i < maxY + 2; i++) {
            if (i % 6 == 0) {
                grid[0][i] = '+'; // Place '+' every 6th position
            } else if (i % 6 != 0) {
                grid[0][i] = '-'; // Fill the in-between with '-'
            }
        }

        // Draw the bottom border
        for (int i = 0; i < maxY + 2; i++) {
            grid[maxX + 1][i] = '-'; // Bottom border
        }

        // Print the grid
        for (int i = 0; i < maxX + 2; i++) {
            for (int j = 0; j < maxY + 2; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
