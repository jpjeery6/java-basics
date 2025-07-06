import java.util.*;
public class ReduntantConnections {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] g ={{1,2},{1,3},{2,3}};
        solution.findRedundantConnection(g);
    }


    static class Solution2 {
        public int[] findRedundantConnection(int[][] edges) {
            HashMap<Integer, List<Integer>> g = new HashMap<>();
            HashSet<Integer> visited = new HashSet<>();
            int[] parent = new int[edges.length+1];
            for(int[] e: edges) {
                g.putIfAbsent(e[0], new ArrayList<>());
                g.putIfAbsent(e[1], new ArrayList<>());
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }
            HashSet<Integer> cset = new HashSet<>();
            parent[1] = 1;
            cycle(cset, 1, -1, g, visited, parent);

            for (int i = edges.length - 1; i >= 0; i--) {
                int u = edges[i][0], v = edges[i][1];
                if (cset.contains(u) && cset.contains(v)) {
                    return new int[]{u, v};
                }
            }
            return new int[0];
        }

        private boolean cycle(HashSet<Integer> cset, int i, int p, HashMap<Integer, List<Integer>> g, HashSet<Integer> visited, int[] parent) {
            visited.add(i);

            for (int j: g.get(i)) {
                if (visited.contains(j) && j != p) {
                    int k = i;
                    System.out.println(Arrays.toString(parent));
                    while(k != j) {
                        // System.out.println(k + ", " + j);
                        cset.add(k);
                        k = parent[k];
                    }
                    cset.add(j);
                    return true;
                }
                if (!visited.contains(j)) {
                    parent[j] = i;
                    if (cycle(cset, j, i, g, visited, parent)) return true;
                }

            }
            return false;
        }
    }


    static class Solution1 {
        public int[] findRedundantConnection(int[][] edges) {
            HashMap<Integer, List<Integer>> g = new HashMap<>();
            HashSet<Integer> visited = new HashSet<>();
            for(int[] e: edges) {
                g.putIfAbsent(e[0], new ArrayList<>());
                g.putIfAbsent(e[1], new ArrayList<>());
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }
            HashSet<Integer> cset = new HashSet<>();
            cycle(false, cset, 1, -1, g, visited);

            for (int i = edges.length - 1; i >= 0; i--) {
                int u = edges[i][0], v = edges[i][1];
                if (cset.contains(u) && cset.contains(v)) {
                    return new int[]{u, v};
                }
            }
            return new int[0];
        }

        private void cycle(boolean cycle, HashSet<Integer> cset, int i, int p, HashMap<Integer, List<Integer>> g, HashSet<Integer> visited) {
            visited.add(i);
            System.out.println(i);
            if (cycle) cset.add(i);
            for (int j: g.get(i)) {
                if (visited.contains(j) && j != p) {
                    if (cycle) return;
                    cycle(true, cset, j, -1, g, new HashSet<>());
                }
                if (!visited.contains(j)) cycle(false, cset, j, i, g, visited);
            }
        }
    }
}
