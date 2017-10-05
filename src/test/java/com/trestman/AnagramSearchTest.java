package com.trestman;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AnagramSearchTest {
    @Test
    public void testSortAlphabetically() {
        String words[] = {"a", "cat", "pony", "duck", "parrot71"};
        String sortedWords[] = {"a", "act", "nopy", "cdku", "17aoprrt"};
        List<String> wordList = Arrays.asList(words);
        List<String> sortedWordsList = Arrays.asList(sortedWords);

        for (String word: wordList) {
            String sortedWord = AnagramSearch.sortAlphabetically(word);
            assertTrue(sortedWordsList.contains(sortedWord));
        }
    }

    @Test
    public void testGetAnagramCorpus(){
        String words[] = {"a", "b", "cat", "pony", "nopy", "act", "duck", "parrot71", "tac", "b", "cudk" };
        List<String> wordList = Arrays.asList(words);

        Map<String, HashSet<String>> anagramsCorpus = AnagramSearch.getAnagramCorpus(wordList);

        for (String word: wordList) {
            String sortedWord = AnagramSearch.sortAlphabetically(word);
            assertTrue(anagramsCorpus.get(sortedWord).contains(word));
        }
    }

    @Test
    public void testPrintAnagrams() {
        String lineOfText = "a b cat pony nopy act duck parrot71,  tac b cudk";
        AnagramSearch.searchAndPrint(lineOfText);
    }
}
