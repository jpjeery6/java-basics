import java.util.*;
public class ReconstructIntenary {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> inp = new ArrayList<>();
        inp.add(Arrays.asList("EZE", "AXA"));
        inp.add(Arrays.asList("TIA", "ANU"));
        inp.add(Arrays.asList("ANU", "JFK"));
        inp.add(Arrays.asList("JFK", "ANU"));
        inp.add(Arrays.asList("ANU", "EZE"));
        inp.add(Arrays.asList("TIA", "ANU"));
        inp.add(Arrays.asList("AXA", "TIA"));
        inp.add(Arrays.asList("TIA", "JFK"));
        inp.add(Arrays.asList("ANU", "TIA"));
        inp.add(Arrays.asList("JFK", "TIA"));
        s.findItinerary(inp);
    }

    static class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, TreeSet<String>> g = new HashMap<>();
            for(List<String> t: tickets) {
                String a = t.get(0);
                String b = t.get(1);
                g.putIfAbsent(a, new TreeSet<>());
                g.get(a).add(b);
            }

            String source = "JFK";
            List<String> res = new ArrayList<>();

            res.add(source);
            dfs(g, res, source, tickets.size());
            return res;

        }

        private boolean dfs(Map<String, TreeSet<String>> g, List<String> res, String n, int numTics) {
            if (res.size() == numTics + 1) return true;
            if (g.containsKey(n)) {
                TreeSet<String> itr = new TreeSet<>(g.get(n));
                for(String nei: itr) {
                    g.get(n).remove(nei);
                    res.add(nei);
                    boolean gotRes = dfs(g, res, nei, numTics);
                    if (gotRes) return true;
                    else {
                        res.remove(nei);
                        g.get(n).add(nei);
                    }
                }
            }
            return false;
        }
    }
}
