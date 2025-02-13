import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        int cMFC;
        HashMap<Character, Integer> map =new HashMap<>();
        int max=0;
        int wS=0;
        // base condition for a window to be valid
        for (int wE=0; wE< s.length(); wE++) {
            if (map.containsKey(s.charAt(wE))) {
                map.put(s.charAt(wE), map.get(s.charAt(wE)) +1);
            } else {
                map.put(s.charAt(wE), 1);
            }
            cMFC = getMFCC(map);
            if ((wE - wS+1) - cMFC <=k) {
                max = Math.max(max, (wE - wS+1));
            } else {
                if (map.get(s.charAt(wS)) == 1) {
                    map.remove(s.charAt(wS));
                } else {
                    map.put(s.charAt(wS), map.get(s.charAt(wS)) -1);
                }
                wS++;
            }
        }
        return max;
    }

    private static int getMFCC(HashMap<Character, Integer> map) {
        return Collections.max(map.values());
    }

    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }
}
