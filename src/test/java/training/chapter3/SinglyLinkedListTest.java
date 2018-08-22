package training.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new SinglyLinkedList();
    }

    @Test
    public void newLinkedListIsEmpty() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void addItemToListShouldIncreaseSize() {
        linkedList.addFirst(4);
        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        linkedList.addLast(6);
        assertEquals(2, linkedList.size());
        linkedList.addAfter(0, 2);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void containsInEmptyListShouldReturnFalse() {
        assertFalse(linkedList.contains(2));
    }

    @Test
    public void containsFacts() {
        linkedList.addFirst(2);
        assertTrue(linkedList.contains(2));
        assertFalse(linkedList.contains(5));
    }

    @Test
    public void findValueBeforeFacts() {
        assertNull(linkedList.findValueBefore(4));

        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        assertEquals(new Integer(4), linkedList.findValueBefore(5));
        assertEquals(new Integer(3), linkedList.findValueBefore(4));
        assertEquals(new Integer(1), linkedList.findValueBefore(2));

        assertNull(linkedList.findValueBefore(1));
        assertNull(linkedList.findValueBefore(10));
    }

    @Test
    public void toStringFacts() {
        assertEquals("", linkedList.toString());
        linkedList.addFirst(2);
        assertEquals("2", linkedList.toString());
        linkedList.addFirst(5);
        assertEquals("5 -> 2", linkedList.toString());
    }

    @Test
    public void addLastFacts() {
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        assertEquals(4, linkedList.size());
        assertEquals(new Integer(4), linkedList.findValueBefore(5));
        assertEquals(new Integer(6), linkedList.findValueBefore(7));
    }

    @Test
    public void addAfterFacts() {
        linkedList.addAfter(0, 4);
        assertTrue(linkedList.contains(4));
        linkedList.addAfter(1, 7);
        assertEquals(new Integer(4), linkedList.findValueBefore(7));
    }

    @Test
    public void insertionSortFacts() {
        SinglyLinkedList sorted = SinglyLinkedList.insertionSort(linkedList);
        assertTrue(sorted.isEmpty());

        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addFirst(14);
        linkedList.addFirst(6);
        sorted = SinglyLinkedList.insertionSort(linkedList);
        assertEquals("5 -> 6 -> 10 -> 14", sorted.toString());

        linkedList.addLast(1);
        linkedList.addLast(5);
        linkedList.addFirst(14);
        sorted = SinglyLinkedList.insertionSort(linkedList);
        assertEquals("1 -> 5 -> 5 -> 6 -> 10 -> 14 -> 14", sorted.toString());
    }

    @Test
    public void selectionSortFacts() {
        SinglyLinkedList sorted = SinglyLinkedList.selectionSort(linkedList);
        assertTrue(sorted.isEmpty());

        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addFirst(14);
        linkedList.addFirst(6);
        sorted = SinglyLinkedList.selectionSort(linkedList);
        assertEquals("5 -> 6 -> 10 -> 14", sorted.toString());

        // cuz we remove items from original linkedList to sort it we add them again for next test
        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addFirst(14);
        linkedList.addFirst(6);
        linkedList.addLast(1);
        linkedList.addLast(5);
        linkedList.addFirst(14);
        sorted = SinglyLinkedList.selectionSort(linkedList);
        assertEquals("1 -> 5 -> 5 -> 6 -> 10 -> 14 -> 14", sorted.toString());
    }
}