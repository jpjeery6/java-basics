import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphCycle {

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] visitedDfs = new boolean[V];
         for (int i=0; i<V; i++) {
             if (!visitedDfs[i]) {
                 if (isCyclicDfs(-1,i, adj, visitedDfs))
                     return true;
             }
         }

        Queue<Integer> q = new LinkedList<>();
        boolean [] visitedBfs = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visitedBfs[i]) {
                q.add(i);
                if (isCyclicBfs(adj, visitedBfs, q))
                    return true;
            }
        }
        return false;
    }

    public boolean isCyclicDfs(int parent, int vertex, ArrayList<ArrayList<Integer>> adj, boolean [] visited) {
        visited[vertex] = true;
        for (Integer nbr: adj.get(vertex)) {
            if (!visited[nbr]) {
                if (isCyclicDfs(vertex, nbr, adj, visited))
                    return true;
            }
            else if (nbr != parent) // base condition: if nbr is visited and its not the parent
                return true;
        }
        return false;
    }

    public boolean isCyclicBfs(ArrayList<ArrayList<Integer>> adj, boolean [] visited, Queue<Integer> q) {
        while(!q.isEmpty()){
            Integer v = q.poll();
            if (visited[v]) // base condition: if any visited element is found again in queue - its a cycle
                return true;
            visited[v] = true;

            for (Integer nbr: adj.get(v)) {
                if (!visited[nbr])
                    q.add(nbr);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
