package com.trestman;

import javafx.util.Pair;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SearchPairsTest {

    @Test
    public void testSearch() {
        Integer integers[] = {1, 2, 3, 4, 5, 6};
        Integer sum = 7;

        Set<Pair<Integer, Integer>> pairs = SearchPairs.search(integers, sum);
        assertEquals(3, pairs.size());
        for (Pair<Integer, Integer> pair: pairs) {
            assertEquals(sum, (Integer)(pair.getKey() + pair.getValue()));
        }
    }

    @Test
    public void testPrintAndSearchPairs() {
        Integer integers[] = {1, 2, 3, 4, 5, 6};

        SearchPairs.searchAndPrintPairs(integers, 7);
    }
}
