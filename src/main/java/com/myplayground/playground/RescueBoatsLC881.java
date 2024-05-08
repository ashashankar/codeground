package com.myplayground.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RescueBoatsLC881 {

    public static void main(String[] args) {
        int[] people = {3, 5, 3, 5};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }
    public static int numRescueBoats(int[] people, int limit) {
        int c = 0;
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        while (i<=j) {
            int w = people[i] + people[j];
            if (w < limit) {
                i++;
            }
            j--;
            c++;
        }
        return (i==j)? c+1:c;
    }
}
