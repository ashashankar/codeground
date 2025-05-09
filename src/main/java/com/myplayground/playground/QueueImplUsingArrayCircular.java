package com.myplayground.playground;

/**
 * Array has got limited size capacity.
 * say 100 is the size and elements to be added in the queue are over 100
 * add 10, add 20 , add 30 , add 40, add 50 , add 60 , add 70 , add 80 , add 90, add 100.
 * now remove 10. the index 0 is empty. add 110 - this 110 will be added at index 0 as we determine the index by mod size.
 * circular addition. if size and capacity are equal then queue is full.
 */
public class QueueImplUsingArrayCircular {
    public static void main (String[] args) {
        QueueImpl queue = new QueueImpl();
        try {
            queue.enqueue(10);
            queue.enqueue(11);
            queue.peek();
            queue.dequeue();
            queue.peek();
            queue.enqueue(33);
            queue.dequeue();
            queue.dequeue();
            queue.peek();
            queue.dequeue();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class QueueImpl {
    int[] arr = new int[100];
    int f = -1;
    int r = -1;
    int size = 0;
    int capcatiy = arr.length;
    public void enqueue(int x) throws Exception {
        if (size == capcatiy) {
            throw new Exception("Error : queue is full");
        } else {
            r = (r+1)%capcatiy;
            arr[r] = x;
            size++;
        }
    }

    public int peek() throws Exception {
        if (f == r) {
            throw new Exception("Error : queue is empty");
        }
        System.out.println(arr[f+1]);
        return arr[(f+1)%capcatiy];
    }

    public void dequeue() throws Exception{
        if (size == 0) {
            throw new Exception("Error : queue is empty");
        }
        f = (f+1)%capcatiy;
        size--;
    }
}
