package com.trestman;

import java.util.*;

public class AnagramSearch {

    static public String sortAlphabetically(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        return sortedString;
    }

    static public Map<String, HashSet<String>> getAnagramCorpus(List<String> words) {
        Map<String, HashSet<String>> wordsCorpus = new HashMap<>();
        for(String word: words) {
            String alphanumericallySorted = sortAlphabetically(word);
            if (wordsCorpus.containsKey(alphanumericallySorted) == false ) {
                HashSet<String> anagrams = new HashSet<>();
                anagrams.add(word);
                wordsCorpus.put(alphanumericallySorted, anagrams);
            }
            else {
                Set<String> anagrams = wordsCorpus.get(alphanumericallySorted);
                anagrams.add(word);
            }
        }
        return wordsCorpus;
    }

    static public void printAnagrams(Map<String, HashSet<String>> wordsCorpus) {

        for (String normalizedWord: wordsCorpus.keySet()) {
            for (String anagram: wordsCorpus.get(normalizedWord)) {
                Set<String> anagarams = wordsCorpus.get(normalizedWord);
                if (anagarams.size() > 1) {
                    System.out.printf("%s, ", anagram);
                }
            }
            System.out.println();
        }
    }

    static public void searchAndPrint(String lineOfText){
        String[] words = lineOfText.split("\\s+");
        Map<String, HashSet<String>> anagramCorpus = getAnagramCorpus(Arrays.asList(words));
        printAnagrams(anagramCorpus);
    }
}
