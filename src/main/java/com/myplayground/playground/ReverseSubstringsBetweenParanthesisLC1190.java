package com.myplayground.playground;
import java.util.Stack;
public class ReverseSubstringsBetweenParanthesisLC1190 {

    public static void main(String[] args) {
        String str = "(abcd)";
        String rev = reverseParentheses(str);
        System.out.println(rev);
    }

    public static String reverseParentheses(String s) {
        char[] input = s.toCharArray();
        Stack<Integer> indexes = new Stack<>();
        for (int i=0; i<input.length; i++) {
            if(input[i] == '(') {
                indexes.push(i);
            } else if (input[i] == ')') {
                int st = indexes.pop();
                reverse(input, st+1, i-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<input.length; j++) {
            if (input[j] != '(' && input[j] != ')') {
                sb.append(input[j]);
            }
        }
        return sb.toString();
    }

    public static void reverse(char[] input, int s, int e) {
        while (s < e) {
            char ch = input[s];
            input[s] = input[e];
            input[e] = ch;
            s++;
            e--;
        }
    }
}
