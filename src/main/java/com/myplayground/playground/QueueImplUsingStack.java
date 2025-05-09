package com.myplayground.playground;

import java.util.Stack;

public class QueueImplUsingStack {
    public static void main(String[] args) {
        QueueSt queueSt = new QueueSt();
        queueSt.enqueue(10);
        queueSt.enqueue(14);
        queueSt.enqueue(13);
        queueSt.enqueue(11);
        queueSt.dequeue();
        queueSt.dequeue();
        queueSt.dequeue();
        System.out.println(queueSt.peek());



        queueSt.dequeue();

        queueSt.print();
        queueSt.enqueue(110);
        queueSt.enqueue(141);
        queueSt.enqueue(135);
        queueSt.enqueue(112);
        queueSt.print();
    }
}

class QueueSt {
    Stack<Integer> enqueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();
    public void enqueue(int x) {
        enqueStack.push(x);
    }

    public void dequeue() {
        if (dequeueStack.isEmpty()) {
            while (!enqueStack.isEmpty()) {
                dequeueStack.push(enqueStack.pop());
            }
        }
        dequeueStack.pop();
    }

    public int peek() {
        return dequeueStack.peek();
    }

    public void print() {
        System.out.println(enqueStack);
    }
}
