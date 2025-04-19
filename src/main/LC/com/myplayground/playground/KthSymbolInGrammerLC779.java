package com.myplayground.playground;
import java.net.Inet4Address;
import java.util.*;
public class KthSymbolInGrammerLC779 {
    public static void main(String[] args) {
        System.out.println(kthGrammar(3, 3)); //nlogK and sc : height of the tree
        //System.out.println(getKthGrammerBS(5,5));// nlogn and sc = 0(1)
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1 )return 0;

       // int parent = kthGrammar(n-1, (int)Math.ceil((double)k/2));
        int parent = kthGrammar(n-1, (int)Math.ceil((double)k/2));
        boolean isKOdd = (k % 2 == 1);
        boolean isParentOdd = (parent % 2 == 1);
        System.out.println(n + " "+ k);
        if (isParentOdd) {
            return isKOdd?1:0;
        } else {
            return isKOdd?0:1;
        }
    }

    public static int getKthGrammerBS(int n, int k) {
        int curr = 0;
        int left = 1; int right = (int)Math.pow(2, n-1);
        while (left  <= right) {
            int mid = left + (right - left )/2;
            if (k > mid) {
                left = mid +1;
                curr = (curr==1)?0:1;
            } else {
                right = mid-1;

            }
        }
        return curr;
    }


}
