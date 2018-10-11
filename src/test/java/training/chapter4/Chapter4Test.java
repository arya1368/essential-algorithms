package training.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;
import static training.chapter4.Chapter4.*;

public class Chapter4Test {

    @Test
    public void indexOfFacts() {
        int[] arr = {1, 2, 123, 95, -41, 17};
        assertEquals(-1, indexOf(arr, 4));
        assertEquals(-1, indexOf(arr, 6));
        assertEquals(-1, indexOf(arr, 0));
        assertEquals(0, indexOf(arr, 1));
        assertEquals(2, indexOf(arr, 123));
    }

    @Test
    public void findMinimumFacts() {
        int[] arr = {1};
        assertEquals(1, findMinimum(arr));
        arr = new int[]{12, 19, 93, 9};
        assertEquals(9, findMinimum(arr));
    }

    @Test
    public void findMaximumFacts() {
        int[] arr = {1};
        assertEquals(1, findMaximum(arr));
        arr = new int[]{12, 19, 93, 9};
        assertEquals(93, findMaximum(arr));
    }

    @Test
    public void findAverageFacts() {
        int[] arr = {1};
        assertEquals(1, findAverage(arr));
        arr = new int[]{12, 19, 93, 9};
        assertEquals(33, findAverage(arr));
        arr = new int[]{1, 2, 3, 4, 5};
        assertEquals(3, findAverage(arr));
    }

    @Test
    public void findMedianFacts() {
        int[] arr = {0};
        assertEquals(0, findMedian(arr));
        arr = new int[] {1, 3, 4, 7, 8, 8, 9};
        assertEquals(7, findMedian(arr));
    }
}