package training.chapter3;

public class SinglyLinkedList {
    private Cell head;
    private int size;

    public SinglyLinkedList() {
        head = new Cell();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int value) {
        Cell c = new Cell(value);
        c.next = head.next;
        head.next = c;
        size++;
    }

    public void addLast(int value) {
        Cell cur = head;
        while (cur.next != null)
            cur = cur.next;

        Cell c = new Cell(value);
        c.next = cur.next;
        cur.next = c;
        size++;
    }

    public void addAfter(int index, int value) {
        Cell cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }

        Cell c = new Cell(value);
        c.next = cur;
        cur.next = c;
        size++;
    }

    public boolean contains(int target) {
        for (Cell cur = head.next; cur != null; cur = cur.next) {
            if (cur.value == target)
                return true;
        }

        return false;
    }

    public Integer findValueBefore(int target) {
        for (Cell cur = head; cur.next != null; cur = cur.next) {
            if (cur.next.value == target)
                return cur.value;
        }

        return null;
    }

    public static SinglyLinkedList insertionSort(SinglyLinkedList list) {
        SinglyLinkedList sorted = new SinglyLinkedList();
        for (Cell cur = list.head.next; cur != null; cur = cur.next) {
            Cell c = new Cell(cur.value);
            Cell afterMe = sorted.head;
            while (afterMe.next != null && c.value > afterMe.next.value)
                afterMe = afterMe.next;

            c.next = afterMe.next;
            afterMe.next = c;
        }

        return sorted;
    }

    public static SinglyLinkedList selectionSort(SinglyLinkedList list) {
        SinglyLinkedList sorted = new SinglyLinkedList();
        while (list.head.next != null) {
            Cell beforeBiggest = list.head;
            int biggest = beforeBiggest.next.value;
            Cell cur = list.head.next;
            while (cur.next != null) {
                if (cur.next.value > biggest) {
                    biggest = cur.next.value;
                    beforeBiggest = cur;
                }
                cur = cur.next;
            }

            sorted.addFirst(beforeBiggest.next.value);
            beforeBiggest.next = beforeBiggest.next.next;
        }

        return sorted;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        for (Cell cur = head.next; cur != null; cur = cur.next)
            str += cur.value != null ? String.format("%d -> ", cur.value) : "";

        return str.length() > 0 ? str.substring(0, str.length() - " -> ".length()) : str;
    }

    private static class Cell {
        Integer value;
        Cell next;

        public Cell() {
            this(null);
        }

        public Cell(Integer value) {
            this(value, null);
        }

        public Cell(Integer value, Cell next) {
            this.value = value;
            this.next = next;
        }
    }
}
