package com.myplayground.temp;

/**
 * This class show fibonacci recursion , memoization and tabulation implemenation.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int x = fibonacci(n-1) + fibonacci(n-2);
        return x;
    }
}
