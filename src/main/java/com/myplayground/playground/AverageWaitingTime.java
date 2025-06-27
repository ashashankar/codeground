package com.myplayground.playground;

public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers = {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        int start = customers[0][0];
        int end = start + customers[0][1];
        double wait = end - start;
        int n = customers.length;

        for (int i=1; i<customers.length; i++) {
            int newStart = customers[i][0];
            int newWait = customers[i][1];
            if (newStart <= end) {
                int s = newStart + (end - newStart);
                end = s + newWait;
                wait += end - newStart;
            } else {
                wait += newWait;
                end = newStart+newWait;
            }
        }
        return (wait /n);
    }
}
