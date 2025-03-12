package com.myplayground.playground;

class SnakeGame {

    int[][] grid = null;
    int[][] f = null;
    int f_idx = 0;
    int food_row = -1;;
    int food_col = -1;
    int curRow = 0;
    int curCol = 0;
    int width = 0;
    int height = 0;
    int score = 0;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        grid = new int[height][width];
        f = food;
        setFood();
    }

    public void setFood() {
        if (f_idx == f.length) return;
        int[] f_place = f[f_idx];
        food_row = f_place[0];
        food_col = f_place[1];
        grid[food_row][food_col] = -1;
        f_idx++;
    }

    public int move(String direction) {
        int[] dir = getCoordinates(direction);
        curRow = curRow  + dir[0];
        curCol = curCol+ dir[1];
        if (check()) return -1;

        if (curRow == food_row && curCol == food_col) {
            score += 1;
            grid[food_row][food_col] = 0;
            setFood();
        }

        return score;
    }

    public boolean check() {
        if (curCol == width ||curCol < 0 ) return true;
        if (curRow == height ||curRow < 0 ) return true;


        return false;
    }

    public int[] getCoordinates(String direction) {
        if (direction.equals("R")) {
            return new int[]{0, 1};
        } else if (direction.equals("L")) {
            return new int[]{0, -1};
        } else if (direction.equals("U")) {
            return new int[]{-1, 0};
        } else if (direction.equals("D")) {
            return new int[]{1, 0};
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}};
        String[][] dirs = {{"D"},{"D"},{"R"},{"U"},{"U"},{"L"},{"D"},{"R"},{"R"},{"U"},{"L"},{"L"},{"D"},{"R"},{"U"}};
        SnakeGame obj = new SnakeGame(3, 3, food);
        for (String[] d : dirs) {
            System.out.println(obj.move(d[0]));


    }


    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */