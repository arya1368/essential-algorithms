package training.chapter4;

public class SparseArray {

    private ArrayRow sentinel;

    public SparseArray() {
        sentinel = new ArrayRow(-1);
    }

    public void add(int row, int column, int value) {
        ArrayRow cur = sentinel;
        while (cur.next != null && cur.next.rowNumber < row) {
            cur = cur.next;
        }
        ArrayEntry newEntry = new ArrayEntry(column, value);
        if (row == cur.rowNumber) {
            ArrayEntry curEntry = cur.sentinel;
            while (curEntry.next != null && curEntry.next.columnNumber < column) {
                curEntry = curEntry.next;
            }
            newEntry.next = curEntry.next;
            curEntry.next = newEntry;
        } else {
            ArrayRow newRow = new ArrayRow(row);
            newRow.next = cur.next;
            cur.next = newRow;
            newRow.sentinel.next = newEntry;
        }
    }

    private static class ArrayRow {
        int rowNumber;
        ArrayRow next;
        ArrayEntry sentinel;

        ArrayRow(int rowNumber) {
            this.rowNumber = rowNumber;
            sentinel = new ArrayEntry(-1, null);
        }
    }

    private static class ArrayEntry {
        int columnNumber;
        Integer value;
        ArrayEntry next;

        ArrayEntry(int columnNumber, Integer value) {
            this.columnNumber = columnNumber;
            this.value = value;
        }
    }
}
