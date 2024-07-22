package com.myplayground.playground;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortthePeopleLC2418 {
    public static void main(String[] args) {
        String[] ppl  = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        ArrayList<pair> people = new ArrayList<>();
        for (int i=0; i<ppl.length; i++) {
            pair p = new pair(ppl[i], heights[i]);
            people.add(p);
        }
        sortPeople(people);
        Collections.reverse(people);
        for (pair p : people)
            System.out.println(p.getName());
    }

    public static void sortPeople(ArrayList<pair> ppl) {
        ppl.sort((a1, a2)-> a1.getH() -a2.getH());
    }
}

@Getter
class pair {
    int h;
    String name;
    public pair(String name, int h) {
        this.name = name;
        this.h = h;
    }
}
