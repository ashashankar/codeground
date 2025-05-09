package com.myplayground.playground;

public class MinimumAddToMakeParanthesisBalancedLC921 {
    public static void main(String[] args) {

    }

    public static int minAdds(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')' && count > 0) {
                count--;
            }
        }
        int closed = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ')') {
                closed++;
            } else if (s.charAt(i) == '(' && closed > 0) {
                closed--;
            }
        }
        return count+closed;
    }
}
