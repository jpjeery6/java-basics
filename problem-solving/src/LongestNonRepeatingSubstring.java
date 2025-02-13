import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestNonRepeatingSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> windowChars = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        int curr=0, max=0;
        for (int i=0; i < s.length(); i++) {
            if (windowChars.contains(s.charAt(i))) {
                while (queue.peek() != s.charAt(i)) {
                    windowChars.remove(queue.poll());
                }
                windowChars.remove(queue.poll());
                windowChars.add(s.charAt(i));
                queue.add(s.charAt(i));
                curr = windowChars.size();
            } else {
                windowChars.add(s.charAt(i));
                queue.add(s.charAt(i));
                curr++;
            }
            if (curr> max) max = curr;
        }
        return max;
    }
}
