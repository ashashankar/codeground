import java.util.HashMap;

public class LC138CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node head = null;
        new LC138CopyListWithRandomPointer().copyRandomList(head);

    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create the deep copy of the list, keeping track of the original and copied nodes in a map.
        HashMap<Node, Node> nodemap = new HashMap<>();
        Node temp = head;

        // Create the deep copy of each node and store it in the map
        while (temp != null) {
            nodemap.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        // Step 2: Set the next and random pointers for the copied nodes.
        temp = head;
        while (temp != null) {
            // Set the next pointer for the copied node.
            if (temp.next != null) {
                nodemap.get(temp).next = nodemap.get(temp.next);
            }
            // Set the random pointer for the copied node.
            if (temp.random != null) {
                nodemap.get(temp).random = nodemap.get(temp.random);
            }
            temp = temp.next;
        }

        // Step 3: Return the head of the copied list.
        return nodemap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}