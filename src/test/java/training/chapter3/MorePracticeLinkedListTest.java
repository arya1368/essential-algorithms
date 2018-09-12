package training.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MorePracticeLinkedListTest {

    private MorePracticeLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new MorePracticeLinkedList();
    }

    @Test
    public void createNewList_listIsEmpty() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void addToList_increaseListSize() {
        linkedList.add(2);
        assertEquals(1, linkedList.size());
        linkedList.add(3);
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void addCycle() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(3);
        assertFalse(linkedList.hasCycle());

        linkedList.linkTailTo(2);
        assertTrue(linkedList.hasCycle());
    }

    @Test
    public void findMiddleIndexTest() {
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(1, linkedList.findMiddleIndex());
        linkedList.add(3);
        assertEquals(2, linkedList.findMiddleIndex());
        linkedList.add(4);
        assertEquals(2, linkedList.findMiddleIndex());
    }

    @Test
    public void addAllTest() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        MorePracticeLinkedList another = new MorePracticeLinkedList();
        another.add(4);
        another.add(5);
        another.add(6);

        assertEquals("1 -> 2 -> 3", linkedList.toString());
        linkedList.addAll(another);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6", linkedList.toString());
        linkedList.add(7);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7", linkedList.toString());
    }

    @Test
    public void reverseTest() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals("1 -> 2 -> 3", linkedList.toString());
        linkedList.reverse();
        assertEquals("3 -> 2 -> 1", linkedList.toString());
    }
}