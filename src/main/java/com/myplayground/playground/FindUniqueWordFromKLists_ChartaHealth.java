package com.myplayground.playground;

import java.util.*;

/**
 * Given k lists of strings (L1, L2, ..., Lk), find all strings that appear in exactly one list (not once globally, but only present in one of the lists regardless of duplicates within that list).
 */
public class FindUniqueWordFromKLists_ChartaHealth {


    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("cat", "dog", "hamster", "cat"));
        input.add(Arrays.asList("dog", "hamster", "crow", "crow", "mouse", "mouse", "mouse"));
        input.add(Arrays.asList("cat", "dog", "cat"));
        input.add(Arrays.asList("dog", "hamster", "crow", "crow"));

        List<String> result = findStringsInExactlyOneList(input);
        System.out.println(result); // Output: [mouse]
    }

    public static List<String> findStringsInExactlyOneList(List<List<String>> inputLists) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> listCountMap = new HashMap<>();
        for (List<String>  inputList : inputLists) {
            Set<String>  uniqueInList = new HashSet<>(inputList);
            for (String word : uniqueInList) {
                    listCountMap.put(word, listCountMap.getOrDefault(word, 0)+1);
            }
        }

        for (Map.Entry<String, Integer> entry : listCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
