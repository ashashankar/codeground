package com.myplayground.playground;

class z_algo {

    //  prints all occurrences of pattern in text using
    // Z algo
    public static void findAndCountOccrrences(String text, String pattern) {
        String s = pattern + "$" + text;
        int[] z = constructZArray(s);
        int count = 0;
        for (int i=0; i<z.length; ++i) {
            if (z[i] == pattern.length()) {
                count++;
            }
        }
        if (count > 0 ) {
            System.out.println("pattern found and occurs "+ count + " times");
        }
    }

    public static int[] constructZArray(String str) {
        int[] z = new int[str.length()];
        int start = 0;
        int end = 0;
        int n = str.length();
        for (int i = 1; i<n; ++i) {
            if (i > end) {
                start = end = i;
                while (end < n && str.charAt(end - start) == str.charAt(end)) {
                    end++;
                }
                z[i] = end - start;
                end--;
            } else {
                int k = i - start ;
                if (z[k] < end - start +1) {
                    z[i] = z[k];
                } else {
                    end  = i;
                    while (end < n && str.charAt(end - start) == str.charAt(end)) {
                        end++;
                    }
                    z[i] = end - start;
                    end--;
                }
            }
        }
        return z;
    }

    // Driver program
    public static void main(String[] args)
    {
        String text = "aadaabbddaabbtaabbdu";
        String pattern = "aabbd";

        findAndCountOccrrences(text, pattern);
    }
}