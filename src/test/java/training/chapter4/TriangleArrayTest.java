package training.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleArrayTest {

    @Test
    public void triangleArrayTest() {
        assertEquals(1, new TriangleArray(1).size());
        assertEquals(3, new TriangleArray(2).size());
        assertEquals(6, new TriangleArray(3).size());
        assertEquals(10, new TriangleArray(4).size());
        assertEquals(15, new TriangleArray(5).size());
        assertEquals(21, new TriangleArray(6).size());
        assertEquals(28, new TriangleArray(7).size());
    }

    @Test
    public void mapToIndexTest() {
        TriangleArray arr = new TriangleArray(1);
        assertEquals(0, arr.mapToIndex(0, 0));

        arr = new TriangleArray(4);
        assertEquals(5, arr.mapToIndex(2, 2));
    }
}