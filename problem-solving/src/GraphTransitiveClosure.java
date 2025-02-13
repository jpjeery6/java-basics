import java.util.ArrayList;

public class GraphTransitiveClosure {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}};
        transitiveClosure(4, arr);
    }

    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(N);
        for (int i=0; i<N; i++) {
            res.add(new ArrayList<>(N));
            for (int j =0; j<N; j++) {
                res.get(i).add(0);
            }
        }

        for (int i=0; i<N ;i++) {
            dfs(i,i, graph, res, N);
        }
        return res;
    }

    static void dfs(int p, int v, int graph[][], ArrayList<ArrayList<Integer>> res, int N) {
        // v is reachable from p
        res.get(p).set(v, 1);
        // explore v
        for (int i=0; i<N; i++) {
            if (graph[v][i] == 1 && v!=i && res.get(p).get(i) == 0) {
                dfs(p, i, graph, res, N);
            }
        }
    }




}
