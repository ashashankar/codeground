package com.myplayground.playground;

import java.util.HashMap;

public class LRUCacheLC146 {
    public static void main(String[] args) {
        LRU lrucache = new LRU(3);
        lrucache.put(1, 10);
        lrucache.put(2, 5);
        System.out.println(lrucache.get(1));
        lrucache.put(3, 3);
        lrucache.put(4,2);
        System.out.println(lrucache.get(2));

    }
}

class LRU {

        HashMap<Integer, LLNode> cache = new HashMap<>();
        LLNode head = new LLNode(0,0);
        LLNode tail = new LLNode(0, 0);
        int capacity = 0;
        LRU(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

        public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.prev);
        }
        insert(new LLNode(key, value));
        System.out.println(cache);
    }

        public int get(int key) {
        if (cache.containsKey(key)) {
            LLNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

        private void remove(LLNode node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

        public void insert(LLNode node) {
        cache.put(node.key, node);
        LLNode headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }

}

class LLNode {
    LLNode prev; LLNode next;
    int val; int key;
    LLNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}