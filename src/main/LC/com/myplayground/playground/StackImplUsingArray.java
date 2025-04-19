package com.myplayground.playground;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * push
 * top
 * pop
 * size
 * isEmpty
 */
public class StackImplUsingArray {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        //myStack.pop();
        System.out.println(myStack.isEmpty());
        myStack.push(10);
        myStack.push(20);
        System.out.println(myStack.size());
        myStack.pop();
        myStack.push(30);
        myStack.printStack();
    }

}

 class Stack {
    int[] st = null;
    int size = 0;
    int top = -1;
    int capacity = 100;
    Stack() {
        st = new int[100];
    }

    public void push(int x) {
        if (size < capacity ) {
            top++;
            st[top] = x;
            size++;
        } else {
            throw new StackOverflowError("Full Stack");
        }
    }

    public int pop() {
        if (top != -1) {
            int x = st[top];
            top--;
            size--;
            return x;
        } else {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void printStack() {
        System.out.println(Arrays.toString(st));
    }
}