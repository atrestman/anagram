package com.trestman;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class SearchPairs {

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

    static public void printPairs(List<Pair<Integer, Integer>> pairs) {
        for (Pair<Integer, Integer> pair: pairs) {
            System.out.printf("{%d,%d}, ", pair.getKey(), pair.getValue());
        }
        System.out.println();
    }

    static public void searchAndPrintPairs(Integer[] integers, Integer sum) {
        List<Pair<Integer, Integer>> pairs = search(integers, sum);
        printPairs(pairs);

    }
}
