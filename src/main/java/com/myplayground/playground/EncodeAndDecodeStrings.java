package codeground.src.main.java.com.myplayground.playground;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("neet");
        input.add("code");
        input.add("**@)##199a");
        input.add("you");
        String encoded = new Practice().encode(input);
        System.out.println(encoded);
        System.out.println(new Practice().decode(encoded));
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int j = 0;
        while (j < str.length()) {
            int i = j;
            while (str.charAt(i) != '#') {
                i++;
            }
            String num = str.substring(j, i);
            int len = Integer.valueOf(num);
            j = i;
            String word = str.substring(j+1, j+len+1);
            j = j+len+1;
            result.add(word);

        }
        return result;
    }
}


