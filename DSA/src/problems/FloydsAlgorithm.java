package problems;

import datastructures.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FloydsAlgorithm {
    private static LinkedList createListWith(int... values) {
        LinkedList list = new LinkedList(10);
        for(int v: values) {
            list.append(v);
        }
        return list;
    }

    @Test
    public void GivenListWith1Node_FindMiddleNode_ShouldReturnTheNode() {
        LinkedList list = createListWith();
        assertEquals(list.findMiddleNode().value, 10);
    }

    @Test
    public void GivenListWith2Nodes_FindMiddleNode_ShouldReturnThe1stNode() {
        LinkedList list = createListWith(20);
        assertEquals(list.findMiddleNode().value, 10);
    }

    @Test
    public void GivenListWithEvenNodes_FindMiddleNode_ShouldReturnRightNode() {
        LinkedList list = createListWith(20, 30, 40);
        assertEquals(list.findMiddleNode().value, 20);
    }

    @Test
    public void GivenListWithOddNodes_FindMiddleNode_ShouldReturnRightNode() {
        LinkedList list = createListWith(20, 30, 40, 50);
        assertEquals(list.findMiddleNode().value, 30);
    }
}
