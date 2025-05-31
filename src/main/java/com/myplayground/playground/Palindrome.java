public class Palindrome {
    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        boolean result = new Practice().isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        String str = s.toUpperCase().replaceAll("[^A-Za-z0-9]", "");
        return check(0, str.length() -1, str);
    }

    public boolean check(int st, int e, String s) {
        while (st <= e) {
            if (s.charAt(st) != s.charAt(e)) return false;
            st++;
            e--;
        }
        return true;
    }
}
