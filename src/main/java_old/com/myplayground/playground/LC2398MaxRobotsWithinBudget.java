package com.myplayground.playground;

import java.util.Deque;
import java.util.LinkedList;

public class LC2398MaxRobotsWithinBudget {
    public static void main(String[] args) {
        int[] runningCost = {2, 1, 3, 4, 5};
        int[] chargeTimes = {3, 6, 1, 3, 4};
        int budget = 25;
        System.out.println(new LC2398MaxRobotsWithinBudget().maximumRobots(chargeTimes, runningCost, budget));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int sum = 0;
        int j=0;
        int len = chargeTimes.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i=0; i<len; i++) {
            sum += runningCosts[i];
            while (!dq.isEmpty() && chargeTimes[i] > dq.getLast()) {
                dq.pollLast();
            }
            dq.addLast(i);
            int cost = dq.getFirst() + (j-i+1) * sum;
            if (cost >budget) {
                if (dq.peekFirst() == i) {
                    dq.pollFirst();
                }
                sum -= runningCosts[i];
                i++;

            }
        }
        return len - j;
    }
}
