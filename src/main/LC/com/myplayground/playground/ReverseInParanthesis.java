package com.myplayground.playground;

/**
 * Reverse nested paranthesis strings only and remove paranthesis
 * ffff(rab)ssss(kail)oll
 * expected ffffrabssssliakall
 */
public class ReverseInParanthesis {

    public  static void main(String[] args) {
        String s = "(bar)";
        int firstIndexb = s.lastIndexOf("(");
        int lastIndexb = s.indexOf(")", firstIndexb);
        while (firstIndexb != -1) {
            StringBuilder revStr = new StringBuilder(s.substring(firstIndexb+1, lastIndexb)).reverse();
            String first = s.substring(0, firstIndexb);
            String second = s.substring(lastIndexb+1);
            s = first + revStr + second;
            firstIndexb = s.lastIndexOf("(");
            lastIndexb = s.indexOf(")", firstIndexb);
        }

        System.out.println(s);
    }
}
