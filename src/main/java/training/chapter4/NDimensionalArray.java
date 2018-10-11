package training.chapter4;

public class NDimensionalArray {

    private int[] values;
    private final int[] lowerBounds;
    private final int[] sliceSize;

    public NDimensionalArray(int[] bounds) {
        int numDimensions = bounds.length / 2;
        lowerBounds = new int[numDimensions];
        sliceSize = new int[numDimensions];
        int slice_size = 1;
        for (int i = numDimensions - 1; i >= 0; i--) {
            sliceSize[i] = slice_size;
            lowerBounds[i] = bounds[2 * i];
            int upperBound = bounds[2 * i + 1];
            int boundSize = upperBound - lowerBounds[i] + 1;
            slice_size *= boundSize;
        }
        values = new int[slice_size];
    }

    public int mapIndicesToIndex(int[] indices) {
        int index = 0;
        for (int i = 0; i < indices.length; i++) {
            index += (indices[i] - lowerBounds[i]) * sliceSize[i];
        }
        return index;
    }

    public int size() {
        return values.length;
    }
}
