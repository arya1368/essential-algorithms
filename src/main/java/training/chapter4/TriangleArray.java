package training.chapter4;

public class TriangleArray {

    private int[] values;

    public TriangleArray(int n) {
        values = new int[(n * n + n) / 2];
    }

    public int mapToIndex(int i, int j) {
        return ((i * i + i) / 2) + j;
    }

    public int size() {
        return values.length;
    }
}
