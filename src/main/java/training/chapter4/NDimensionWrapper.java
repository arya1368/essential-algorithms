package training.chapter4;

public class NDimensionWrapper {

    private int[] wrapped;
    private int[] slicesSize;
    private Bound[] bounds;
    private int numDimension;

    public NDimensionWrapper(Bound... bounds) {
        this.bounds = bounds;
        numDimension = bounds.length;
        slicesSize = new int[numDimension];
        int sliceSize = 1;
        for (int i = numDimension - 1; i >= 0; i--) {
            slicesSize[i] = sliceSize;
            sliceSize *= bounds[i].getSize();
        }

        wrapped = new int[sliceSize];
    }

    public void setValue(int value, int... coordinates) {
        int index = calculateIndex(coordinates);
        wrapped[index] = value;
    }

    public int getValue(int... coordinates) {
        int index = calculateIndex(coordinates);
        return wrapped[index];
    }

    private int calculateIndex(int[] coordinates) {
        int index = 0;
        for (int i = 0; i < numDimension; i++)
            index += slicesSize[i] * (coordinates[i] - bounds[i].lower);
        return index;
    }

    public static class Bound {
        private int lower;
        private int upper;

        public Bound(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        public int getSize() {
            return upper - lower + 1;
        }
    }
}
