package problems;

import datastructures.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ReverseBetween {
    @Test
    public void testReverseBetween() {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        list.reverseBetween(1, 3);
        System.out.println(list);

        LinkedList expected = new LinkedList(1);
        expected.append(4);
        expected.append(3);
        expected.append(2);
        expected.append(5);
        System.out.println(expected);

        assertEquals(expected.toString(), list.toString());
    }
}
