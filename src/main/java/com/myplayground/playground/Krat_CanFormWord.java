import java.util.*;

/**
 * check if note1 jumbled can form any of the word from words array
 */
class Krat_CanFormWord {

    public static void main(String[] args) {
        String note1 = "tyac";
        String[] words = {"baby", "cat", "troy", "well"};
        for (String word: words) {
            if (canFormWord(word, note1)) {
                return word;
            }
        }
        return "-";
    }

    public word canFormWord(String word, String match) {
        HashMap<Character, Integer> match_map = new HashMap<>();
        for (char c: match.toCharArray()) {
            match_map.put(c, match_map.getOrDefault(c, 0)+1);
        }

        for (char ch : word.toCharArray()) {
            if (!match_map.containsKey(ch) || match_map.get(ch) == 0)
                return false;

            match_map.put(ch, match_map.get(ch) -1);
        }
        return true;
    }
}