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
    public void addItemToList_increaseSize() {
        linkedList.add(4);
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());

        linkedList.add(5);
        linkedList.add(8);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void addOneTwoThree_popOneTwoThree() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(new Integer(1), linkedList.pop());
        assertEquals(new Integer(2), linkedList.pop());
        assertEquals(new Integer(3), linkedList.pop());
    }

    @Test
    public void afterPop_sizeDecrease() {
        linkedList.add(4);
        linkedList.add(16);
        assertEquals(2, linkedList.size());
        linkedList.pop();
        assertEquals(1, linkedList.size());
        linkedList.pop();
        assertTrue(linkedList.isEmpty());
    }
}