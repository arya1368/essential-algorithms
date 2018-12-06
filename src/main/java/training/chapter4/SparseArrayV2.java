package training.chapter4;

public class SparseArrayV2 {

    public static int DEFAULT = -1;

    private Row sentinel;

    public SparseArrayV2() {
        sentinel = new Row(-1);
    }

    public int getValue(int rowNum, int columnNum) {
        Row r = findRowBefore(rowNum).next;
        if (r == null || r.rowNumber > rowNum)
            return DEFAULT;

        Entry e = r.findColumnBefore(columnNum).next;
        if (e == null || e.columnNumber > columnNum)
            return DEFAULT;

        return e.value;
    }

    public void setValue(int value, int rowNum, int columnNum) {
        if (value == DEFAULT) {
            delete(rowNum, columnNum);
            return;
        }

        Entry newEntry = new Entry(columnNum, value);
        Row r = findRowBefore(rowNum);
        if (r.next == null || r.next.rowNumber > rowNum) {
            Row newRow = new Row(rowNum, r.next);
            newRow.sentinel.next = newEntry;
            r.next = newRow;
        } else {
            r = r.next;
            Entry e = r.findColumnBefore(columnNum);
            if (e.next == null || e.next.columnNumber > columnNum) {
                newEntry.next = e.next;
                e.next = newEntry;
            } else {
                e.next.value = value;
            }
        }
    }

    public void delete(int rowNum, int columnNum) {
        Row r = findRowBefore(rowNum).next;
        if (r.next != null && r.rowNumber == rowNum) {
            Entry e = r.findColumnBefore(columnNum);
            if (e.next != null && e.next.columnNumber == columnNum) {
                e.next = e.next.next;
            }
        }
    }

    private Row findRowBefore(int rowNum) {
        Row before = sentinel;
        while (before.next != null && before.next.rowNumber < rowNum)
            before = before.next;

        return before;
    }

    public static class Row {
        int rowNumber;
        Entry sentinel;
        Row next;

        public Row(int rowNumber) {
            this(rowNumber, null);
        }

        public Row(int rowNum, Row next) {
            this.rowNumber = rowNum;
            this.next = next;
            sentinel = new Entry(-1);
        }

        public Entry findColumnBefore(int columnNum) {
            Entry before = sentinel;
            while (before.next != null && before.next.columnNumber < columnNum)
                before = before.next;

            return before;
        }
    }

    public static class Entry {
        int columnNumber;
        int value;
        Entry next;

        public Entry(int columnNumber) {
            this(columnNumber, DEFAULT);
        }

        public Entry(int columnNumber, int value) {
            this.columnNumber = columnNumber;
            this.value = value;
        }
    }
}
