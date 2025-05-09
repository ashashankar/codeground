package com.myplayground.playground;

public class SubstringCheckRollingHash {
    public static void main(String[] args) {
        String input = "ABDCBAIBDCSQ";
        String find = "CBA";
        if (findSubstring(input, find)) {
            System.out.println(find + " is present.");
        }
    }

    public static boolean findSubstring(String input, String find) {
        int len = find.length();
        int base = 26;
        long expectedHash = 0L;
        int mod = 1000000007;
        for (int i=0; i<len; i++) {
            expectedHash += (long)((find.charAt(i) * Math.pow(base, len - i - 1))%mod);
        }
        System.out.println(expectedHash+ " expectedHash");

        long firstWindowHash = 0l;
        for (int j=0; j<len; j++) {
            firstWindowHash += (long)((input.charAt(j) * Math.pow(base, len - j - 1))%mod);
        }
        if (firstWindowHash == expectedHash) {
            return true;
        }
        int i=1;
        int j= i+len-1;
        while (j < input.length()) {
            long newWindowHash = (long)(((firstWindowHash - (input.charAt(i-1) * Math.pow(base , len-1)))) * base + input.charAt(j))%mod;

            if (newWindowHash == expectedHash) {
                //System.out.println("found match "+ expectedHash + "  "+ newWindowHash);
                return true;
            }
            firstWindowHash = newWindowHash;
            i++;
            j++;
        }

        return false;
    }
}
