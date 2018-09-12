package training.chapter3;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new DoublyLinkedList<>();
    }

    @Test
    public void createNewList_listIsEmpty() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void addItemToLastItemInList_increaseSize() {
        linkedList.addLast(4);
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());

        linkedList.addLast(5);
        linkedList.addLast(8);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void addOneTwoThree_popOneTwoThree() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        assertEquals(new Integer(1), linkedList.pop());
        assertEquals(new Integer(2), linkedList.pop());
        assertEquals(new Integer(3), linkedList.pop());
    }

    @Test
    public void addFirst_addingOneTwoThree_popThreeTwoOne() {
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertEquals(new Integer(3), linkedList.pop());
        assertEquals(new Integer(2), linkedList.pop());
        assertEquals(new Integer(1), linkedList.pop());
    }

    @Test
    public void afterPop_sizeDecrease() {
        linkedList.addLast(4);
        linkedList.addLast(16);
        assertEquals(2, linkedList.size());
        linkedList.pop();
        assertEquals(1, linkedList.size());
        linkedList.pop();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void swapFacts() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        assertEquals("1 -> 2", linkedList.toString());
        linkedList.swap(0, 1);
        assertEquals("2 -> 1", linkedList.toString());
    }
}