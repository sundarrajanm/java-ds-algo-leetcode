package datastructures;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if(length == 0) {
            return null;
        }

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {}
    public boolean insert(int index, int value) {
        return false;
    }

    public void printList() {
        System.out.println("_______________");
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("_______________");
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }
    public void getLength() {
        System.out.println("Length: " + length);
    }

    // Using Floyd's Tortoise and Hare algorithm
    public Node findMiddleNode() {

        if(head == tail || head.next == tail) {
            // length is 1 or 2
            return head;
        }

        Node tortoise = head;
        Node hare = head.next;

        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        return tortoise;
    }

    public boolean hasLoop() {
        if(head == tail || head.next == tail) {
            return false;
        }

        Node slowPtr = head;
        Node fastPtr = head.next;

        while(fastPtr != null && fastPtr.next != null) {
            if(slowPtr == fastPtr) {
                return true;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        return null;
    }
}
