package com.myplayground.playground;

public class ReverseALinkedList {

    public static void main(String[] args) {
        ListNode head = createLinkedList();
        System.out.println(head.print());
        ListNode revHead = reverseLinkedList(head);
        System.out.println(revHead.print());
    }

    public static ListNode createLinkedList() {
        int i = 1;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (i < 8) {
            ListNode node = new ListNode(i+1);
            i++;
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode currNext = null;
        while (curr != null) {
            currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        return prev;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


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