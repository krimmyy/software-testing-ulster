package test;

import main.Sorting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortingTest {

    @Test
    void testSortArrayValid() {
        int[] unsorted = { 5, 6, 3, 1, 2 };
        int[] expected = { 1, 2, 3, 5, 6 };
        Assertions.assertArrayEquals(expected, Sorting.sortArray(unsorted));
    }

    @Test
    void testSortArrayInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Sorting.sortArray(null);
        });
    }

    @Test
    void testSortArrayEmpty() {
        int[] unsorted = {};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, Sorting.sortArray(unsorted));
    }

    @Test
    void testSortArraySingleElement() {
        int[] unsorted = { 7 };
        int[] expected = { 7 };
        Assertions.assertArrayEquals(expected, Sorting.sortArray(unsorted));
    }

}
