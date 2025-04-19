package com.myplayground.playground;

public class MyCircularDequeueLC641 {
    public static void main(String[] args) {
        String[] tasks = {"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"};
        //int[] values = {[3], [1], [2], [3], [4], [], [], [], 4, []}

    }
    int size = 0;
    int length = 0;
    Node head = new Node(-1);
    Node tail = new Node(-1);
    public MyCircularDequeueLC641(int k) {
        size = k;
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node nextNode = head.next;
        nextNode.prev = node;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        length = length +1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node previousNode = tail.prev;
        previousNode.next = node;
        tail.prev = node;
        node.prev = previousNode;
        node.next = tail;
        length = length +1;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node node = head.next;
        node.next.prev = head;
        head.next = node.next;
        length = length -1;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        length = length -1;
        return true;
    }

    public int getFront() {
        return head.next.val;
    }

    public int getRear() {
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean isFull() {
        return (size==length);
    }
}

class Node {
    Node next;
    Node prev;
    int val;
    Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
