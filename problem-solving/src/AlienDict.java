import java.util.*;
public class AlienDict {

    public static void main(String[] args) {
        String[] words = {"hrn","hrf","er","enn","rfnn"};
        Solution solution = new Solution();
        solution.foreignDictionary(words);

    }


    static class Solution {
        public String foreignDictionary(String[] words) {
            Map<Character, Set<Character>> adj = new HashMap<>();
            for (int i=0; i<words.length-1; i++) {
                String w1 = words[i];
                String w2 = words[i+1];
                for (int j = 0; j< w1.length(); j++) {
                    adj.putIfAbsent(w1.charAt(j), new HashSet<>());
                }
                for (int j = 0; j< w2.length(); j++) {
                    adj.putIfAbsent(w2.charAt(j), new HashSet<>());
                }
                for (int j = 0; j< Math.min(w1.length(), w2.length()); j++) {
                    if (w1.charAt(j) != w2.charAt(j)) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        break;
                    }
                }
            }

            // apply toposort
            Map<Character, Integer> ind = new HashMap<>();
            Set<Character> visited = new HashSet<>();
            Queue<Character> q = new LinkedList<>();
            int numNodes = 0;
            for (char c: adj.keySet()) {
                numNodes++;
                ind.putIfAbsent(c, 0);
                for (char ch: adj.get(c)) {
                    ind.putIfAbsent(ch, 0);
                    ind.put(ch, ind.get(ch)+1);
                }
            }
            for (char c: ind.keySet()) {
                if (ind.get(c) == 0) q.add(c);
            }
            StringBuilder sb = new StringBuilder();

            while (!q.isEmpty()) {
                char c = q.poll();
                sb.append(c);
                visited.add(c);
                for (char nei: adj.get(c)) {
                    if (!visited.contains(nei)) {
                        int ideg = ind.get(nei);
                        if (ideg == 0 || ideg-1 == 0) q.add(nei);
                        ind.put(nei, ideg-1);
                    }
                }
                numNodes--;
            }

            return numNodes == 0 ? sb.toString() : "";
        }
    }

}
