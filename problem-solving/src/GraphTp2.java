import java.util.ArrayList;
import java.util.Collections;

public class GraphTp2 {

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e)
    {
        ArrayList<Integer> res = new ArrayList<>(v);
        boolean[] visited = new boolean[v];
        for (int i=0; i< v; i++)
            if (!visited[i])    dfs(i, edges, visited, res);
        // System.out.println(res);
        Collections.reverse(res);
        return res;
    }

    static void dfs(int v, ArrayList<ArrayList<Integer>> edges, boolean[] visited, ArrayList<Integer> res) {
        for (ArrayList<Integer> pair: edges) {
            if (pair.get(0) == v) {
                dfs (pair.get(1), edges, visited, res);
            }
        }
        if (!visited[v]) res.add(v);
        visited[v] = true;
    }

    public static void main(String[] args) {

    }
}
