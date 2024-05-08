package com.myplayground.playground;

import java.util.List;

/**
 * LC25
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        LinkedListNode head = createLinkedList();
        int k = 2;

        System.out.println( head.print());
        LinkedListNode result = reverseKNodes(head, k);
        System.out.println( result.print());
    }


    public static  LinkedListNode reverseKNodes(LinkedListNode head , int k) {
        LinkedListNode temp = head;
        LinkedListNode prevNode = null;
        LinkedListNode nextNode = null;
        while (temp != null) {
            LinkedListNode kthNode =  findKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) prevNode.next = nextNode;
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverseListNode(temp);
            if (temp == head) {
                head = kthNode;
            } else {

                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }


    public static LinkedListNode findKthNode(LinkedListNode node, int k) {

        LinkedListNode temp = node;
        if (k-1>0) {
            temp = temp.next;
        }
        return temp;
    }
    public static LinkedListNode createLinkedList() {
        int i = 1;
        LinkedListNode head = new LinkedListNode(-1);
        LinkedListNode tail = head;
        while (i < 10) {
            LinkedListNode node = new LinkedListNode(i+1);
            i++;
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }

    public static LinkedListNode reverseListNode(LinkedListNode node) {
        LinkedListNode temp  = node;
        LinkedListNode prev = null;
        LinkedListNode currNext = temp.next;
        while (temp != null) {
            temp.next = prev;
            prev = temp;
            temp = currNext;
            if(currNext != null) {
                currNext = currNext.next;
            }
        }
        return prev;
    }

}

class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode() {}
    LinkedListNode(int val) { this.val = val; }
    LinkedListNode(int val, LinkedListNode next) { this.val = val; this.next = next; }


    public String print() {
        LinkedListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " -> ");
            head = head.next;
        }
        return sb.toString();
    }
}