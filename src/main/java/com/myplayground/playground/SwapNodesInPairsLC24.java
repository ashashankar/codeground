package com.myplayground.playground;

public class SwapNodesInPairsLC24 {
    public static void main(String[] args) {
        ListNode head =  createLinkedList();
        int k = 2;
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prev = null;
        while (temp != null) {
            ListNode kthNode = findEverySecondNode(temp);
            if (kthNode ==  null) {
                if (prev != null) prev.next = temp;
                break;
            } else {
                 nextNode = kthNode.next;
                 kthNode.next = null;
                 reverseListNode(temp);
                 if (head == temp) {
                     head = kthNode;
                 } else {
                     prev.next = kthNode;
                 }
                 prev = temp;
                 temp = nextNode;
            }
        }
        System.out.println(head.print());

    }
    public static ListNode createLinkedList() {
        int i = 1;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (i < 5) {
            ListNode node = new ListNode(i);
            i++;
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }

    public static ListNode reverseListNode(ListNode node) {
        ListNode temp  = node;
        ListNode prev = null;
        ListNode currNext = null;
        while (temp != null) {
            currNext = temp.next;
            temp.next = prev;
            prev = temp;
            temp = currNext;

        }
        return prev;
    }

    public static ListNode findEverySecondNode(ListNode temp) {
        int k = 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
}

 class ListNode {
      int val;
      ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

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
