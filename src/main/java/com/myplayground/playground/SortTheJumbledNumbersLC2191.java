package com.myplayground.playground;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class SortTheJumbledNumbersLC2191 {

    public static void main(String[] args) {
        int[] mapping = {9,8,7,6,5,4,3,2,1,0};
        int[] nos = {0,1,2,3,4,5,6,7,8,9};
        sortJumbledNos(mapping, nos);
    }



    public static int[] sortJumbledNos(int[] mapping, int[] nos) {
        ArrayList<Pair> result = new ArrayList<>();
        int mappedNumber = 0;
        for (int i=0; i<nos.length; i++) {
            int number = nos[i];
            int r = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            if (number > 0) {
                while (number > 0) {
                    r = number % 10;
                    int map = mapping[r];
                    number = number / 10;
                    temp.add(map);

                }
            } else {
                temp.add(mapping[number]);
            }

            for (int j=temp.size() -1; j >=0 ; j--) {
                mappedNumber = 10 * mappedNumber + temp.get(j);
            }
            Pair p = new Pair(i, mappedNumber);
            result.add(p);
            System.out.println(mappedNumber + " ");
            mappedNumber = 0;

        }
        result.sort(Comparator.comparingInt(Pair::getNumber));
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<result.size(); i++) {
            answer.add(nos[result.get(i).getIdx()]);
        }
        return answer.stream().mapToInt(i ->i).toArray();
    }
}


@Getter
@Setter
class Pair {
    int idx;
    int number;
    Pair (int i, int num) {
        this.idx = i;
        this.number = num;
    }
}