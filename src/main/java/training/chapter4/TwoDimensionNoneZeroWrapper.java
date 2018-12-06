package training.chapter4;

public class TwoDimensionNoneZeroWrapper {

    private int[][] wrapped;
    private DimensionBound xBound;
    private DimensionBound yBound;

    public TwoDimensionNoneZeroWrapper(DimensionBound xBound, DimensionBound yBound) {
        this.xBound = xBound;
        this.yBound = yBound;
        wrapped = new int[xBound.upper - xBound.lower + 1][yBound.upper - yBound.lower + 1];
    }

    public void addValue(int value, int x, int y) {
        wrapped[x - xBound.lower][y - yBound.lower] = value;
    }

    public int getValue(int x, int y) {
        return wrapped[x - xBound.lower][y - yBound.lower];
    }

    public static class DimensionBound {
        private int lower;
        private int upper;

        public DimensionBound(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
}
