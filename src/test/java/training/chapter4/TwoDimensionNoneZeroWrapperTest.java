package training.chapter4;

import org.junit.Test;
import training.chapter4.TwoDimensionNoneZeroWrapper.DimensionBound;

import static org.junit.Assert.*;

public class TwoDimensionNoneZeroWrapperTest {

    @Test
    public void noneZeroFacts() {
        TwoDimensionNoneZeroWrapper twoDimensionNoneZero =
                new TwoDimensionNoneZeroWrapper(new DimensionBound(1, 10),
                        new DimensionBound(2000, 2010));

        twoDimensionNoneZero.addValue(100, 1, 2006);
        twoDimensionNoneZero.addValue(300, 3, 2002);
        twoDimensionNoneZero.addValue(400, 7, 2010);

        assertEquals(100, twoDimensionNoneZero.getValue(1, 2006));
        assertEquals(300, twoDimensionNoneZero.getValue(3, 2002));
        assertEquals(400, twoDimensionNoneZero.getValue(7, 2010));
    }
}