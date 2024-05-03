package com.myplayground.playground;

import java.util.HashSet;
public class IncreasingSequence {
    public static void main(String[] args) {
       //int[] arr = {40, 50, 60, 10, 20, 30};
        //int[] arr = {1, 3, 2, 1};
       // int[] arr = {10, 1, 2, 3};
        //int[] arr = {1, 2, 1, 2};
       // int[] arr = {1, 3, 2};
        int[] arr = {1,2,5,3,5};
        boolean result  = solution(arr);
        System.out.println(result);
    }


    public static boolean solution(int[] sequence) {
        int count = 0;
        int index = 0;
        for (int i=1 ; i< sequence.length; i++) {
            if (sequence[i-1] >= sequence[i]) {
                count++;
                index = i-1;
            }
        }
        if (count > 1) {
            return false;
        } else if (count == 1) {

            if (index == 0 || index == (sequence.length - 2)) {
                return true;
            } else if (sequence[index+1] > sequence[index-1] || sequence[index+2] > sequence[index]) {
                return true;
            }
        }
        return false;
    }
}


