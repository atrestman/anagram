package com.trestman;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class SearchPairs {

    /**
     * Search for pairs which which sum is the passed in parameter
     *
     * @param integers
     * @param sum
     * @return
     */
    static public List<Pair<Integer, Integer>> search(Integer[] integers, Integer sum) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < integers.length; i++) {
            for (int j = i+1; j < integers.length; j++) {
                if (integers[i] + integers[j] == sum) {
                    Pair<Integer, Integer> pair = new Pair<>(integers[i], integers[j]);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    /**
     * Output matching pairs to stdio
     *
     * @param pairs
     */
    static private void printPairs(List<Pair<Integer, Integer>> pairs) {
        for (Pair<Integer, Integer> pair: pairs) {
            System.out.printf("{%d,%d}, ", pair.getKey(), pair.getValue());
        }
        System.out.println();
    }

    /**
     * Search for matching pars and print them out
     *
     * @param integers
     * @param sum
     */
    static public void searchAndPrintPairs(Integer[] integers, Integer sum) {
        List<Pair<Integer, Integer>> pairs = search(integers, sum);
        printPairs(pairs);

    }
}
