import java.util.HashMap;

public class ProgrammerString {

    public static void main(String[] args) {
        // String a = "programmerxxxprozmerqgram";
        String b = "progrgxrammerrxproxgrammer";
        String c = "proghadasjhggrammerbbbbprograaygdjhagdjammer";
        System.out.println(solve(c));
    }

    static boolean match(HashMap<Character, Integer> curr, HashMap<Character, Integer> map) {
        for(char c: map.keySet()) {
            if (!curr.containsKey(c))
                return false;
            if (curr.get(c) < map.get(c))
                return false;
        }
        return true;
    }

    private static int solve(String s) {
        String p = "programmer";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()) {
            map.putIfAbsent(c,0);
            map.put(c, map.get(c)+1);
        }

        HashMap<Character, Integer> curr1 = new HashMap<>();
        char[] arr = s.toCharArray();
        int ans1 = 0;
        for(int i=0; i< s.length(); i++) {
            if (map.containsKey(arr[i])) {
                curr1.putIfAbsent(arr[i],0);
                curr1.put(arr[i], map.get(arr[i])+1);
            }
            if(match(curr1, map)) {
                ans1 = i;
                break;
            }
        }

        int ans2 = 0;
        HashMap<Character, Integer> curr2 = new HashMap<>();
        for(int i= s.length()-1; i >=0 ; i--) {
            if (map.containsKey(arr[i])) {
                curr2.putIfAbsent(arr[i],0);
                curr2.put(arr[i], map.get(arr[i])+1);
            }
            if(match(curr2, map)) {
                ans2 = i;
                break;
            }
        }

        return ans2-ans1-2;
    }
}
