package com.myplayground.playground;

public class MinimumRemoveToMakeValidParanthesisLC1249 {
    public static void main(String[] arr) {
        String s = "(a(b(c)d)";//"a)b(c)d";
        String filtered = minRemove(s, 0, s.length());
        System.out.println(filtered);

    }

    public static String minRemove(String s, int start , int end) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=start; i<end; i++) {
            if(s.charAt(i) == '(') {
                count++;
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ')' && count > 0) {
                count--;
                sb.append(s.charAt(i));
            } else if (s.charAt(i) != ')') {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(count);
        int i= sb.toString().length() -1;

        while (count != 0) {
            if (sb.toString().charAt(i) == '(') {
                sb.deleteCharAt(i);
                count--;
            }

            i--;
        }

        return sb.toString();
    }


}
