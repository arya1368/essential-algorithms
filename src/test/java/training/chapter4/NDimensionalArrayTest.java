package training.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class NDimensionalArrayTest {

    @Test
    public void OneDimensionTest() {
        NDimensionalArray arr = new NDimensionalArray(new int[]{0, 0});
        assertEquals(1, arr.size());

        arr = new NDimensionalArray(new int[]{0, 2});
        assertEquals(3, arr.size());

        arr = new NDimensionalArray(new int[]{1, 5});
        assertEquals(5, arr.size());
    }

    @Test
    public void TwoDimensionTest() {
        NDimensionalArray arr = new NDimensionalArray(new int[]{0, 0, 0, 0});
        assertEquals(1, arr.size());

        arr = new NDimensionalArray(new int[]{0, 2, 0, 2});
        assertEquals(9, arr.size());

        arr = new NDimensionalArray(new int[] {1, 10, 2000, 2011});
        assertEquals(120, arr.size());
    }

    @Test
    public void mapIndeciesToIndexTest() {
        NDimensionalArray arr = new NDimensionalArray(new int[] {1, 10, 2000, 2011});
        assertEquals(0, arr.mapIndicesToIndex(new int[] {1, 2000}));
        assertEquals(1, arr.mapIndicesToIndex(new int[] {1, 2001}));
        assertEquals(13, arr.mapIndicesToIndex(new int[] {2, 2001}));
        assertEquals(119, arr.mapIndicesToIndex(new int[] {10, 2011}));
    }
}