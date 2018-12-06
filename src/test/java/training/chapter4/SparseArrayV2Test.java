package training.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class SparseArrayV2Test {

    @Test
    public void facts() {
        SparseArrayV2 sparseArray = new SparseArrayV2();
        sparseArray.setValue(100, 0, 2);
        sparseArray.setValue(500, 3, 5);
        sparseArray.setValue(300, 1518, 25);

        assertEquals(100, sparseArray.getValue(0, 2));
        assertEquals(500, sparseArray.getValue(3, 5));
        assertEquals(300, sparseArray.getValue(1518, 25));

        sparseArray.setValue(150, 0, 2);
        assertEquals(150, sparseArray.getValue(0, 2));

        sparseArray.delete(0, 2);
        assertEquals(SparseArrayV2.DEFAULT, sparseArray.getValue(0, 2));
    }
}