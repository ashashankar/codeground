import java.util.ArrayList;
import java.util.Collections;

public class MergKLinkedListsLC23 {

    public static void main(String[] args) {
        ListNode[] lists = null;
        ListNode root = new MergKLinkedListsLC23().mergeKLists(lists);
        System.out.println(root.toString());
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> allInOne = mergeList(lists);
        Collections.sort(allInOne);
        return createLL(allInOne);
    }

    public ArrayList<Integer>  mergeList(ListNode[] lists) {
        ArrayList<Integer> result = new ArrayList<>();
        for (ListNode l : lists) {
            ListNode temp = l;
            while (temp != null) {
                result.add(temp.val);
                temp = temp.next;
            }
        }
        return result;
    }

    public ListNode  createLL(ArrayList<Integer> allinone) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i  : allinone) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {

        return " "+ val + " ->";
    }
  }
