package com.myplayground;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N-ry tree post order traversal iterative approach
 * LC 580
 */
public class NAryTreePostOrderiterativeApproach {
    public static void main(String[] args) {
        Node[] levelorder = new Node[6];
        postOrderTraversal(levelorder);
    }

    public static List<Integer> postOrderTraversal(Node[] root) {
        Stack<NodePair> st = new Stack<NodePair>();
        NodePair nodeR = new NodePair(root[0], false);
        List<Integer> result = new ArrayList<>();
        st.add(nodeR);
        while (!st.isEmpty()) {
            NodePair np = st.pop();
            if (!np.visited) {
                np.visited = true;
                st.push(np);
                List<Node> c = np.getNode().children;

                for (int i=c.size()-1; i >= 0; i--) {
                    st.push(new NodePair(c.get(i), false));
                }
            } else {
                result.add(np.getNode().val);
            }
        }
        return result;
    }
}


@Getter
@Setter
class NodePair {
    boolean visited;
    Node node;

    NodePair(Node n, boolean visited) {

    }

}

@Getter
@Setter
 class Node {

     public int val;
     public List<Node> children;
}