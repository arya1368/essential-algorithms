package training;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static training.Chapter2.*;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 30/07/2018
 */
public class Chapter2Test {

    @Test
    public void randomizeArrayFacts() throws Exception {
        Chapter2.randomizeArray(new String[] {});
        Chapter2.randomizeArray(new String[] {"a"});
        Chapter2.randomizeArray(new String[] {"a", "b"});
        Chapter2.randomizeArray(new String[] {"a", "b", "c"});
        Chapter2.randomizeArray(new String[] {"a", "b", "c", "d"});
        Chapter2.randomizeArray(new String[] {"a", "b", "c", "d", "e"});
    }

    @Test
    public void greatestCommonDivisorRecursiveVersionFacts() throws Exception {
        assertEquals(10, greatestCommonDivisorRecursiveVersion(10, 0));
        assertEquals(1651, greatestCommonDivisorRecursiveVersion(1651, 0));
        assertEquals(2, greatestCommonDivisorRecursiveVersion(4, 2));
        assertEquals(6, greatestCommonDivisorRecursiveVersion(30, 36));
        assertEquals(100, greatestCommonDivisorRecursiveVersion(100, 10000));
        assertEquals(1, greatestCommonDivisorRecursiveVersion(17, 13));
    }

    @Test
    public void raiseToPowerFacts() throws Exception {
        assertEquals(Math.pow(2, 1), raiseToPower(2, 1), 0.0001);
        assertEquals(Math.pow(2, 2), raiseToPower(2, 2), 0.0001);
        assertEquals(Math.pow(2, 3), raiseToPower(2, 3), 0.0001);
        assertEquals(Math.pow(2, 4), raiseToPower(2, 4), 0.0001);
        assertEquals(Math.pow(2, 8), raiseToPower(2, 8), 0.0001);
        assertEquals(Math.pow(2, 10), raiseToPower(2, 10), 0.0001);
        assertEquals(Math.pow(2, 23), raiseToPower(2, 23), 0.0001);
    }

    @Test
    public void findFactorsFacts() throws Exception {
        assertEquals(Arrays.asList(2, 2, 2), findFactors(8));
        assertEquals(Arrays.asList(2, 5), findFactors(10));
        assertEquals(Arrays.asList(2, 2, 3, 3, 13 , 13, 17), findFactors(2 * 2 * 3 * 3 * 13 * 13 * 17));
    }

    @Test
    public void findFactorsV2Facts() throws Exception {
        assertEquals(Arrays.asList(2, 2, 2), findFactorsV2(8));
        assertEquals(Arrays.asList(2, 5), findFactorsV2(10));
        assertEquals(Arrays.asList(2, 2, 3, 3, 13 , 13, 17), findFactorsV2(2 * 2 * 3 * 3 * 13 * 13 * 17));
    }

    @Test
    public void findPrimesFacts() throws Exception {
        assertEquals(Arrays.asList(2, 3, 5, 7), findPrimes(10));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13), findPrimes(13));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), findPrimes(20));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37), findPrimes(40));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59), findPrimes(60));
    }

    @Test
    public void findPrimeFacts() throws Exception {
        System.out.println(findPrime(1, 5));
        System.out.println(findPrime(2, 5));
        System.out.println(findPrime(3, 3));
    }
}