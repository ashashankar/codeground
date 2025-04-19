package com.myplayground.playground;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String print() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " -> ");
            head = head.next;
        }
        return sb.toString();
    }
}
