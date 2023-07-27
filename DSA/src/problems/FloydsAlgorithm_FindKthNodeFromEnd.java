package problems;

import datastructures.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloydsAlgorithm_FindKthNodeFromEnd {
    @Test
    public void GivenListWithFewerNodesThan_K_WhenFind_ReturnNull() {
        LinkedList list = new LinkedList(1);
        list.append(20);
        list.append(30);
        list.append(40);
        assertNull(list.findKthFromEnd(10));
    }

    @Test
    public void GivenList_WhenFindKthNode_ReturnCorrectly() {
        LinkedList list = new LinkedList(1);
        list.append(20);
        list.append(30);
        list.append(40);
        assertEquals(30, list.findKthFromEnd(2).value);
    }
}
