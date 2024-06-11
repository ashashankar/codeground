package com.myplayground.playground;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinHeap {
    public static void main(String[] args) {
        Integer[] a =  new Integer[]{2, 3, 5, 13,21, 22, 23, 48};
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(a).collect(Collectors.toList());
        int newElement = 9;
        insert(list, newElement);
        System.out.println(list);
        deleteRootOfMinHeap(list);
        System.out.println(list);

    }

    private static void insert(ArrayList<Integer> list, int newElement) {
        list.add(newElement);
        int i = list.size()-1;
        while (i > 0) {
            int parent = (i-1)/2;
            if (list.get(parent) >  list.get(i)) {
                swap(i, parent, list);
                i = parent;
            } else {
                break;
            }
        }
    }

    private static void deleteRootOfMinHeap(ArrayList<Integer> list) {
        int len = list.size();
        swap(len -1, 0, list);
        list.remove(len-1);
        len = list.size();
        int i = 0;
        while (i < len) {
            int left = (2 * i) +1;
            int right = (2 * i) + 2;
            int minidx = i;
            if (left < len &&  list.get(left) < list.get(minidx)) {
                swap(left, i, list);
                minidx = left;
            }
            if (right < len && list.get(right) <  list.get(minidx)) {
                swap(right, i, list);
                minidx = right;
            }
            i++;
        }
    }

    public static void swap(int parent, int i, ArrayList<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(parent));
        list.set(parent, temp);
    }
}
