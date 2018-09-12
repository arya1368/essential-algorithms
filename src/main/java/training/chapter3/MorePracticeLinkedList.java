package training.chapter3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MorePracticeLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MorePracticeLinkedList() {
        head = new Node(null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int item) {
        Node n = new Node(item);
        if (tail == null) {
            tail = n;
            head.next = tail;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void linkTailTo(int i) {
        Node n = head.next;
        for (int index = 0; index < size; index++) {
            if (index == i) {
                tail.next = n;
                break;
            }

            n = n.next;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        for (Node cur = head.next; cur != null; cur = cur.next)
            str += cur.data != null ? String.format("%d -> ", cur.data) : "";

        return str.length() > 0 ? str.substring(0, str.length() - " -> ".length()) : str;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        Node n = head.next;
        while (n != null) {
            if (visited.contains(n))
                return true;

            visited.add(n);
            n = n.next;
        }
        return false;
    }

    public int findMiddleIndex() {
        Node tortoise = head.next;
        Node hare = head.next;

        int middleIndex = 0;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            middleIndex++;
        }

        return middleIndex;
    }

    public void addAll(MorePracticeLinkedList another) {
        tail.next = another.head.next;
        tail = another.tail;
    }

    public void reverse() {
        Stack<Integer> items = new Stack<>();
        while (size != 0)
            items.push(pop());

        while (!items.isEmpty())
            add(items.pop());
    }

    public int pop() {
        Node removed = head.next;
        head.next = removed.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return removed.data;
    }

    public static class Node {
        public Node next;
        public Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }
}
