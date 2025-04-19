package com.myplayground.playground;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DeleteNodesFromLLPresentInArrayLC3217 {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3};
        ListNode head = new ListNode(1);
        ListNode dummy = head;
        for (int i=2; i<=5; i++) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }

        ListNode newLL = new DeleteNodesFromLLPresentInArrayLC3217().removeElements(elements, head);
        System.out.println(newLL.print());

    }

    public ListNode removeElements(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i: nums) {
            hs.add(i);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (hs.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
