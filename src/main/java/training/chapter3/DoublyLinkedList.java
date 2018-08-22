package training.chapter3;

public class DoublyLinkedList<T> {
    private final Cell<T> head;
    private final Cell<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Cell<>();
        tail = new Cell<>();
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        Cell<T> c = new Cell<>(item);
        c.next = tail;
        tail.prev.next = c;
        tail.prev = c;
        size++;
    }

    public int size() {
        return size;
    }


    public T pop() {
        Cell<T> removed = head.next;
        head.next = removed.next;
        removed.next.prev = head;
        size--;
        return removed.value;
    }

    private static class Cell<T> {
        T value;
        Cell<T> next;
        Cell<T> prev;

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
