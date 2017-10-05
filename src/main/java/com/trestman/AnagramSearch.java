package com.trestman;

import java.util.*;

public class AnagramSearch {

    /**
     * Normilize the input string by sorting it alphabetically
     *
     * @param input
     * @return
     */
    static public String sortAlphabetically(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        return sortedString;
    }

    /**
     * Populate anagram words corpus/dictionary from the supplied words
     *
     * @param words
     * @return
     */
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

    /**
     * Print anagrams if their number if more than one found per the assignment
     * specification
     *
     * @param wordsCorpus
     */
    static private void printAnagrams(Map<String, HashSet<String>> wordsCorpus) {

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

    /**
     * Search for anagrams in the supplied input and print them into stdio
     *
     * @param lineOfText
     */
    static public void searchAndPrint(String lineOfText){
        String[] words = lineOfText.split("\\s+");
        Map<String, HashSet<String>> anagramCorpus = getAnagramCorpus(Arrays.asList(words));
        printAnagrams(anagramCorpus);
    }
}
