package com.myplayground.playground;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class HappyNumbers {

    public static void main(String[] args) {
        int n = 2;
        boolean answer = new HappyNumbers().isHappyNumber(n);
        System.out.println(answer);
    }

    int total = Integer.MAX_VALUE;
    public boolean isHappyNumber(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n !=0 ){
                int r = n%10;
                n = n/10;
                sum += Math.pow(r, 2);
            }
            n = sum;

            if (sum == 1) return true;

            if (seenNumbers.contains(sum)) return false;
            seenNumbers.add(sum);
        }
    }

    public boolean isHappyNumberApproachTwo(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(n);
            fast = square(square(n));
        }while (slow != fast);
        return slow == 1;
    }

    public int square(int n){
        int sum = 0;
        while (n != 0) {
            int r = n %10;
            n = n/10;
            sum = (int)Math.pow(n, 2);
        }
        return sum;
    }
}