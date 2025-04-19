package com.myplayground.playground;

import java.util.*;

/**
 * 1 2 3 11 12 13 21 22 23 31 32 33 111 112 113 121 122 123 131 132 133 211 222 223 311 312 313
 * 1111 1112 ....
 */
public class DetermineNithNumber {
    public static void main(String[] args) {
        int n = 10;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> numbers = new ArrayList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int x = 3;
        while (numbers.size() < n) {
            int top = queue.poll();
            numbers.add(top);
            top = top *10;
            int num1 = top +1;
            int num2 = top + 2;
            int num3 = top + 3;
            queue.add(num1);
            queue.add(num2);
            queue.add(num3);
            x += 3;
        }
        System.out.println(numbers.get(n-1));
        System.out.println(Arrays.toString(solve(10)));
    }

    public static int[] solve(int A) {
        Queue<Integer> queue = new LinkedList<>();
        int[] numbers = new int[A];

        queue.add(1);
        queue.add(2);
        queue.add(3);

        int i=0;
        while (numbers.length < A) {
            int top = queue.poll();
            numbers[i] = top;
            i++;
            top = top *10;
            int num1 = top +1;
            int num2 = top + 2;
            int num3 = top + 3;
            queue.add(num1);
            queue.add(num2);
            queue.add(num3);

        }
        return numbers;
    }
}

