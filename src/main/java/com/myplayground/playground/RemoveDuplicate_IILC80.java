package com.myplayground.playground;

import java.util.Arrays;

public class RemoveDuplicate_IILC80 {

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,2,3,3,6};
        int k = new RemoveDuplicate_IILC80().removeDuplicates(a);
        for (int i=0; i<k; i++) {
            System.out.print(a[i]);
        }
    }

    public int removeDuplicates(int[] a) {

      int i = 0;
      for (int j=0; j<a.length; j++) {
          if (i<2 || a[j] != a[i-2]) {
              a[i] = a[j];
              i++;
          }
      }
      return i;

    }
}
