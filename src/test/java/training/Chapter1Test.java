package training;

import org.junit.Test;

import static org.junit.Assert.*;
import static training.Chapter1.*;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 23/07/2018
 */
public class Chapter1Test {

    @Test
    public void greatestCommonDivisorFacts() throws Exception {
        assertEquals(10, greatestCommonDivisor(10, 0));
        assertEquals(1651, greatestCommonDivisor(1651, 0));
        assertEquals(2, greatestCommonDivisor(4, 2));
        assertEquals(6, greatestCommonDivisor(30, 36));
        assertEquals(100, greatestCommonDivisor(100, 10000));
        assertEquals(1, greatestCommonDivisor(17, 13));
    }

    @Test
    public void findLargestFacts() throws Exception {
        assertEquals(5, findLargest(new int[] {1, 2, 3, 4, 5}));
        assertEquals(-4, findLargest(new int[] {-100, -9, -4, -123, -4}));
        assertEquals(100, findLargest(new int[] {100}));
    }

    @Test
    public void isContainsDuplicatesFacts() throws Exception {
        assertFalse(isContainsDuplicates(new int[] {1, 2 , 3}));
        assertFalse(isContainsDuplicates(new int[] {1, -1 , 4}));
        assertTrue(isContainsDuplicates(new int[] {1, 3, 5, 6, 3}));
        assertTrue(isContainsDuplicates(new int[] {1, 1, 5, 6, 3}));
    }

    @Test
    public void isContainsDuplicatesV2Facts() throws Exception {
        assertFalse(isContainsDuplicatesV2(new int[] {1, 2 , 3}));
        assertFalse(isContainsDuplicatesV2(new int[] {1, -1 , 4}));
        assertTrue(isContainsDuplicatesV2(new int[] {1, 3, 5, 6, 3}));
        assertTrue(isContainsDuplicatesV2(new int[] {1, 1, 5, 6, 3}));
    }
}