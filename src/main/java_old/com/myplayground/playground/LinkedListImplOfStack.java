package com.myplayground.playground;

public class LinkedListImplOfStack {
    public static void main(String[] args) {
        StackLL stackLL = new StackLL();
        stackLL.push(10);
        stackLL.push(3);
        stackLL.push(4);
        stackLL.push(22);
        stackLL.print();;
        stackLL.pop();
        stackLL.print();
    }
}

class StackLL {
    Node head = null;
    public void push(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
    }

    public int pop() {
        int x = head.val;
        head = head.next;
        return x;
    }

    public int top() {
        return head.val;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(" "+ temp.val+ " ->");
            temp = temp.next;
        }
    }
}


class Node {
    Node next;
    int val;
    Node(int val) {
        this.val = val;
        next = null;
    }
}