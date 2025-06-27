package com.myplayground.LLD.Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A thread-safe bounded buffer (fixed-capacity queue) implementation using ReentrantLock and Conditions.
 * <p>
 * This class provides blocking put and take operations for producers and consumers.
 * Producers wait if the buffer is full, and consumers wait if the buffer is empty.
 * </p>
 * <p>
 * Typical usage involves one or more producer and consumer threads sharing the same buffer instance.
 * </p>
 *
 * @author YourName
 */
public class BoundedBuffer {
    Queue<Integer> buffer = new LinkedList<>();
    final int MAX_CAPACITY;
    ReentrantLock lock = new ReentrantLock();
    final Condition notfull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    BoundedBuffer(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            while(buffer.size() == MAX_CAPACITY) {
                notfull.await();
            }
            buffer.add(value);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException{
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                notEmpty.await();
            }
            int value = buffer.poll();
            notfull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer(5);
        Thread producer = new Thread(() -> {
            for (int i=1; i<10; i++) {
                try {
                    boundedBuffer.put(i);
                    System.out.println("Produced "+ i);
                    Thread.sleep(100);
                } catch (InterruptedException iex) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i=1; i<10; i++) {
                try {
                    int item = boundedBuffer.take();
                    System.out.println("Consumed "+ item);
                    Thread.sleep(200);
                } catch(InterruptedException iex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
