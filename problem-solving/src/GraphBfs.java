import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {



    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(0); // only traversing connected nodes from 0
        while(!q.isEmpty()) {
            int v = q.poll();
            if (!visited[v]) {
                visited[v] = true;
                res.add(v);
                for (int j: adj.get(v)) {
                    if (!visited[j]) q.add(j);
                }
            }
        }
        return res;
    }
}
