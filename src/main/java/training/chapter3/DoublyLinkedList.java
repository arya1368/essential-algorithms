package training.chapter3;

public class DoublyLinkedList<T> {
    private final Cell<T> head;
    private final Cell<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Cell<>();
        tail = new Cell<>();
        head.next = tail;
        head.type = "HEAD";
        tail.prev = head;
        tail.type = "TAIL";
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        insertCell(head, new Cell<>(item));
    }

    public void addLast(T item) {
        Cell<T> afterMe = tail.prev;
        insertCell(afterMe, new Cell<>(item));
    }

    private void insertCell(Cell<T> afterMe, Cell<T> c) {
        c.prev = afterMe;
        c.next = afterMe.next;
        afterMe.next.prev = c;
        afterMe.next = c;
        size++;
    }

    public T pop() {
        Cell<T> removed = head.next;
        head.next = removed.next;
        removed.next.prev = head;
        size--;
        return removed.value;
    }

    public void swap(int i, int j) {
        Cell<T> cellJ = head.next;
        Cell<T> cellI = head.next;
        Cell<T> cur = head.next;

        for (int counter = 0; counter < size; counter++) {
            if (counter == i)
                cellI = cur;
            if (counter == j)
                cellJ = cur;

            cur = cur.next;
        }

        T temp = cellI.value;
        cellI.value = cellJ.value;
        cellJ.value = temp;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        for (Cell cur = head.next; cur != null; cur = cur.next)
            str += cur.value != null ? String.format("%s -> ", cur.value) : "";

        return str.length() > 0 ? str.substring(0, str.length() - " -> ".length()) : str;
    }

    private static class Cell<T> {
        T value;
        Cell<T> next;
        Cell<T> prev;
        String type;

        public Cell() {
            this(null, null, null);
        }

        public Cell(T value) {
            this(value, null, null);
        }

        public Cell(T value, Cell<T> next, Cell<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
