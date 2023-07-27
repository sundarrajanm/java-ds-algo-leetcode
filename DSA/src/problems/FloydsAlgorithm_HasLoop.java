package problems;

import datastructures.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

import datastructures.Node;
import org.junit.jupiter.api.Test;

public class FloydsAlgorithm_HasLoop {
    @Test
    public void testHasLoopReturnsFalseForEmptyList() {
        LinkedList emptyList = new LinkedList(0);
        emptyList.removeLast();
        assertFalse(emptyList.hasLoop());
    }

    @Test
    public void testHasLoopReturnsFalseForListWithOneNode() {
        LinkedList list = new LinkedList(10);
        assertFalse(list.hasLoop());
    }
    @Test
    public void testHasLoopReturnsTrueForListWithLoop() {
        LinkedList list = new LinkedList(10);
        list.append(20);
        list.append(30);

        Node firstNode = list.get(0);
        Node lastNode = list.get(2);
        lastNode.next = firstNode; // Loop created

        assertTrue(list.hasLoop());
    }
    @Test
    public void testHasLoopReturnsTrueForListWithNoLoop() {
        LinkedList list = new LinkedList(10);
        list.append(20);
        list.append(30);

        assertFalse(list.hasLoop());
    }

}
