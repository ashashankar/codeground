package com.myplayground.playground;

    public class NumbersComplimentLC476 {

        public static void main(String[] args) {
            System.out.println(getCompliment(5));
        }
        public static int getCompliment(int n) {
            if (n == 0) return n;

            int bitLength = Integer.toBinaryString(n).length();
            int mask = (1 << bitLength) -1 ;

            return n  ^ mask;
        }
    }


