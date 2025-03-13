package com.myplayground.playground;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class SnakeGame {

    int width, height, score;
    int[][] food;
    int foodIndex;
    Deque<int[]> snake; // Deque to represent the snake (head at front, tail at back)
    Set<String> snakeBody; // Set to quickly check if the snake's head collides with its body

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;
        this.snake = new LinkedList<>();
        this.snakeBody = new HashSet<>();

        // Snake starts at position (0, 0)
        snake.offerFirst(new int[]{0, 0});
        snakeBody.add("0,0");
    }

    public int move(String direction) {
        // Get new head position based on the direction
        int[] head = snake.peekFirst();
        int newRow = head[0];
        int newCol = head[1];

        if (direction.equals("U")) {
            newRow--;
        } else if (direction.equals("D")) {
            newRow++;
        } else if (direction.equals("L")) {
            newCol--;
        } else if (direction.equals("R")) {
            newCol++;
        }

        // Check if the new head position is out of bounds or collides with the body
        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width || snakeBody.contains(newRow + "," + newCol)) {
            return -1; // Game over
        }

        // Check if snake eats food
        boolean ateFood = false;
        if (foodIndex < food.length && food[foodIndex][0] == newRow && food[foodIndex][1] == newCol) {
            ateFood = true;
            score++;
            foodIndex++;
        }

        // Add new head to the snake
        snake.offerFirst(new int[]{newRow, newCol});
        snakeBody.add(newRow + "," + newCol);

        // If the snake didn't eat food, remove the tail
        if (!ateFood) {
            int[] tail = snake.pollLast();
            snakeBody.remove(tail[0] + "," + tail[1]);
        }

        return score; // Return current score
    }

    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}};
        String[][] dirs = {{"D"},{"D"},{"R"},{"U"},{"U"},{"L"},{"D"},{"R"},{"R"},{"U"},{"L"},{"L"},{"D"},{"R"},{"U"}};
        SnakeGame obj = new SnakeGame(3, 3, food);
        for (String[] d : dirs) {
            System.out.println(obj.move(d[0]));


        }

}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */