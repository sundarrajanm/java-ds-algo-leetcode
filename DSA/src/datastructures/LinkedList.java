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

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        if(head == null) return "[]";

        if(head == tail) return "[ " + this.head.value + " ]";

        if(this.hasLoop()) return "[ has loop ]";

        StringBuilder r = new StringBuilder("[ ");
        Node ptr = this.head;
        while(ptr != null) {
            r.append(ptr.value);
            ptr = ptr.next;

            if(ptr == null) {
                r.append(" ]");
            } else {
                r.append(" -> ");
            }
        }
        return r.toString();
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
        Node firstPtr = this.head;

        int i = k;
        while(i > 0) {
            firstPtr = firstPtr.next;
            if(firstPtr == null) break;
            i--;
        }

        if(firstPtr == null) return null;

        Node secondPtr = this.head;

        while(firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }

    public void reverseBetween(int m, int n) {
        if(this.head == null) return;

        Node dummy = new Node(0);
        dummy.next = this.head;
        Node prev = dummy;

        for(int i=0; i<m; i++) {
            prev = prev.next;
        }

        Node current = prev.next;
        for(int i = (n-m); i > 0; i--) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        this.head = dummy.next;
    }
}
