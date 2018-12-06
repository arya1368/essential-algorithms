package training.chapter4;

import org.junit.Test;
import training.chapter4.NDimensionWrapper.Bound;

import static org.junit.Assert.*;

public class NDimensionWrapperTest {


    @Test
    public void facts() {
        NDimensionWrapper nDimensionWrapper = new NDimensionWrapper(new Bound(1, 10)
                , new Bound(2000, 2010));

        nDimensionWrapper.setValue(100, 1, 2000);
        nDimensionWrapper.setValue(400, 10, 2010);

        assertEquals(100, nDimensionWrapper.getValue(1, 2000));
        assertEquals(400, nDimensionWrapper.getValue(10, 2010));

    }
}