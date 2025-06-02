public class MinWindowSubsting {
    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaabbbbbcdd";//"ADOBECODEBANCab";
        String s2 = "abcdd";//"ABC";
        System.out.println(new MinWindowSubsting().minWindow(s1, s2));
    }
    public String minWindow(String s, String t) {
        if (s.equals(t)) return t;
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            hm.put(t.charAt(i) , hm.getOrDefault(t.charAt(i), 0)+1);
        }
        int len = Integer.MAX_VALUE;
        String result = "";
        for (int j=0; j<s.length(); j++) {
            for (int k=j+1; k<=s.length(); k++) {
                String sub_str = s.substring(j, k);
                if (containsAllChars(sub_str, hm)) {
                    if (sub_str.length() < len) {
                        int l = sub_str.length();
                        len = Math.min(l, len);
                        result = sub_str;
                    }

                }
            }
        }
        return  result;
    }

    public boolean containsAllChars(String s, HashMap<Character, Integer> hm_t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            hm.put(s.charAt(i) , hm.getOrDefault(s.charAt(i), 0)+1);
        }

        for (Map.Entry<Character, Integer> entry : hm_t.entrySet()) {
            if (!hm.containsKey(entry.getKey()) || (hm.get(entry.getKey()) != null && hm.get(entry.getKey()) < entry.getValue()))
                return false;
        }

        return true;
    }
}