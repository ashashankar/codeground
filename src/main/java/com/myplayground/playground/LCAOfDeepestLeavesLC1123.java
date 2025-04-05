
import java.util.*;

public class LCAOfDeepestLeavesLC1123 {
    public static void main(String[] args) {
       TreeNode root = null;
       new LCAOfDeepestLeavesLC1123().lcaDeepestLeaves(root);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ArrayList<Pair> nodes = new ArrayList<>();
        if (root.left == null && root.right == null) return root;

        Queue<Pair> q = new LinkedList<>();
        if (root == null) return root;
        q.offer(new Pair(root, 0, null));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.getNode().left != null) {
                q.offer(new Pair(p.getNode().left, p.getDepth() + 1, p.getNode()));
                nodes.add(new Pair(p.getNode().left, p.getDepth() + 1, p.getNode()));
            }

            if (p.getNode().right != null) {
                q.offer(new Pair(p.getNode().right, p.getDepth() + 1, p.getNode()));
                nodes.add(new Pair(p.getNode().right, p.getDepth() + 1, p.getNode()));
            }
        }
        nodes.sort((a, b) -> b.getDepth() - a.getDepth());
        if (nodes.size() == 1) return nodes.get(0).getNode();
        int maxDepth = nodes.get(0).getDepth();
        HashMap<TreeNode, TreeNode> parentMap= new HashMap<>();
        ArrayList<TreeNode> deepestNodes = new ArrayList<>();
        for (Pair n : nodes) {
            parentMap.put(n.getNode(), n.getParent());
            if (n.getDepth() == maxDepth) {
                deepestNodes.add(n.getNode());
            }
        }
        if (deepestNodes.size() == 1) return deepestNodes.get(0);
        return lca(deepestNodes.get(0), deepestNodes.get(deepestNodes.size() -1 ), parentMap);
    }

    public TreeNode lca(TreeNode a , TreeNode b, HashMap<TreeNode, TreeNode> parentMap) {
        HashSet<TreeNode> nodes = new HashSet<>();
        while (a != null) {
            nodes.add(a);
            a = parentMap.get(a);
        }

        while (b != null) {
            if (nodes.contains(b)) {
                return b;
            }
            b = parentMap.get(b);
        }


        return null;
    }
}

class Pair {
    TreeNode node;
    int depth;
    TreeNode parent;
    Pair(TreeNode node, int d, TreeNode parent) {
        this.node = node;
        this.depth = d;
        this.parent = parent;
    }

    public int getDepth() {
        return this.depth;
    }
    public TreeNode getNode() {
        return this.node;
    }

    public TreeNode getParent() {
        return this.parent;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
