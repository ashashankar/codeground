package com.myplayground.playground;

import java.util.LinkedList;

public class QueueImplUsingLinkedList {
    public static void main(String[] args) {
        QueueLL queue = new QueueLL();
        queue.enqueue(10);
        queue.enqueue(11);
        queue.print();
        System.out.println("  ");
        queue.dequeue();

        queue.enqueue(20);
        System.out.println(queue.peek());
        queue.enqueue(112);
        queue.enqueue(33);
        queue.dequeue();
        System.out.println("final position");
        queue.print();
    }
}

class QueueLL {
    Node front = new Node(-1);
    Node tail = front;
    public void enqueue(int x) {
        Node node = new Node(x);
        tail.next = node;
        tail = tail.next;
    }

    public void dequeue() {
        if (front.val == -1) {
            front = front.next;
        }
        front = front.next;
    }

    public int peek() {
        return front.val;
    }

    public void print() {
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.val+ "->");

            curr = curr.next;
        }
    }
}

class NodeLL {
    Node next;
    int val;
    NodeLL(int x) {
        this.val = x;
        this.next = null;
    }
}
