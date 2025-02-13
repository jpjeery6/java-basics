import java.util.*;
public class CloneGraph {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        solution.cloneGraph(n1);
    }

static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    static class Solution {
        Map<Node, Node> map;
        HashSet<Node> visited;
        public Node cloneGraph(Node node) {
            map = new HashMap<>();
            visited = new HashSet<>();
            dfs(node);
            return map.get(node);
        }

        void dfs(Node node) {
            if (visited.contains(node)) return;
            Node dc = map.containsKey(node) ? map.get(node): new Node(node.val);
            map.putIfAbsent(node, dc);
            visited.add(node);
            for (Node n: node.neighbors) {
                Node dcn = map.containsKey(n) ? map.get(n): new Node(node.val);
                map.putIfAbsent(n, dcn);
                dc.neighbors.add(dcn);
                dfs(n);
            }
        }
    }
}
