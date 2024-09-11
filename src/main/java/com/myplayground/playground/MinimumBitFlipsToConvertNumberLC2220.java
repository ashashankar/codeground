package com.myplayground.playground;

public class MinimumBitFlipsToConvertNumberLC2220 {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        int result = 0;
        for (int i=0; i<32; i++) {
           boolean src =  new MinimumBitFlipsToConvertNumberLC2220().checkBit(x, i);
           boolean dest =  new MinimumBitFlipsToConvertNumberLC2220().checkBit(y, i);
           if (src != dest) {
               result++;
           }
        }
        System.out.println(result);
    }

    public boolean checkBit(int i, int pos) {
        int x = (i >> pos) & 1;
        return (x == 1) ? true: false;
    }
}
