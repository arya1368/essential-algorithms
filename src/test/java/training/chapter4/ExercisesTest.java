package training.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExercisesTest {

    @Test
    public void varianceFact() {
        assertEquals(0, Exercises.variance(new int[] {1, 1}), 0.01);
        assertEquals(2, Exercises.variance(new int[] {1, 3}), 0.01);
    }

    @Test
    public void deviationFact() {
        assertEquals(1.41, Exercises.deviation(new int[] {1, 3}), 0.01);
    }

    @Test
    public void findMedianInSortedArray() {
        assertEquals(6, Exercises.findMedianInSortedArray(new int[] {3, 6, 7}), 0.01);
        assertEquals(6, Exercises.findMedianInSortedArray(new int[] {3, 6, 6, 7}), 0.01);
    }
}