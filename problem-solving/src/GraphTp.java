import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphTp {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,4},{2,4},{3,1},{3,2}};
        solution.canFinish(5, arr);
    }

    public static class Solution {
        class Edge{
            int v1;
            int v2;

            Edge(int v1, int v2) {
                this.v1 = v1;
                this.v2 = v2;
            }
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length <=1) return true;
            int count = 0;
            Map<Integer, Boolean> visited = new HashMap<>();
            Map<Integer, List<Integer>> graph = createGraph(prerequisites, visited);

            for (int i : graph.keySet()) {
                if (!visited.get(i)) {
                    topologicalSort(i, graph, visited, count);
                    if (count >= numCourses) return true;
                }
            }
            System.out.println(count);
            return false;
        }

        public Map<Integer,List<Integer>> createGraph(int[][] prerequisites, Map<Integer, Boolean> visited) {
            int numV = prerequisites.length;
            Map<Integer,List<Integer>> graph = new HashMap<>();
            int x, y;
            for (int i=0; i< numV; i++) {
                y = prerequisites[i][0];
                x = prerequisites[i][1];
                visited.put(x, false);
                visited.put(y, false);
                if (graph.containsKey(x)) {
                    graph.get(x).add(y);
                } else {
                    List<Integer> edges = new ArrayList<>();
                    edges.add(y);
                    graph.put(x, edges);
                }
            }
            return graph;
        }

        public void topologicalSort(int v, Map<Integer,List<Integer>> graph, Map<Integer, Boolean> visited, int count) {
            visited.put(v, true);
            for (int i: graph.get(v)) {
                if (!visited.get(i)) {
                    if (i == v || !graph.containsKey(i)) {
                        count ++;
                        visited.put(i, true);
                    } else {
                        topologicalSort(i, graph, visited, count);
                    }
                    // No cycle
                    count ++;
                }
                // cycle
            }
        }
    }
}


