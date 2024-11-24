package com.myplayground.playground;

public class NumberOfIslandsLC200 {
    public static void main(String[] args) {
        char[][] grid ={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};
        System.out.println(new NumberOfIslandsLC200().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='1'){
                    count++;
                    DFS(grid,i,j);
                }
            }
        }
        return count;
    }


    public static void DFS (char [][] grid, int x, int y){
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]=='0') return;
        grid[x][y]='0';
        DFS(grid,x+1,y);
        DFS(grid,x-1,y);
        DFS(grid,x,y+1);
        DFS(grid,x,y-1);
    }
}
