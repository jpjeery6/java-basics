import java.util.ArrayList;
import java.util.Stack;

public class Dfs {

    public static void dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> recDfs = new ArrayList<>(V);
        ArrayList<Integer> itrDfs = new ArrayList<>(V);
        recDfs(0, adj, new boolean[V], recDfs);
        itrDfs(0, adj, new boolean[V], itrDfs);
        System.out.println("RecDfs:" + recDfs); // 0,2,4,3,1
        System.out.println("ItrDfs:" + itrDfs); // 0,2,4,3,1
    }

    public static void recDfs(Integer vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        ArrayList<Integer> edges = adj.get(vertex);
        dfs.add(vertex);
        visited[vertex] = true;
        for (Integer edge: edges) {
            if (!visited[edge]) {
                recDfs(edge, adj, visited, dfs);
            }
        }
    }

    public static void itrDfs(Integer start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        ArrayList<Integer> edges;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited[vertex]) { // explore only if not visited
                dfs.add(vertex);
                visited[vertex] = true;
                edges = adj.get(vertex);
                for (int i = edges.size()-1; i>=0; i--) { // going in reverse order here bcz as itrDfs and recDfs can produce different valid orders
                    Integer neighbour =  edges.get(i);
                    stack.push(neighbour);
                }
            }
        }
    }



    public static void main(String[] args) {
        int V=10;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>(V);
        for (int i=0;i<V; i++) {
            adj.add(new ArrayList<Integer>());
        }

//        adj.get(0).add(2);
//        adj.get(0).add(3);
//        adj.get(0).add(1);
//
//        adj.get(1).add(0);
//
//        adj.get(2).add(0);
//        adj.get(2).add(4);
//
//        adj.get(3).add(0);
//
//        adj.get(4).add(2);

        // ---
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(4);
        adj.get(0).add(8);

        adj.get(1).add(5);
        adj.get(1).add(6);
        adj.get(1).add(9);

        adj.get(2).add(4);

        adj.get(3).add(7);
        adj.get(3).add(8);

        adj.get(5).add(8);

        adj.get(6).add(7);
        adj.get(6).add(9);
        dfsOfGraph(V, adj);
    }
}
