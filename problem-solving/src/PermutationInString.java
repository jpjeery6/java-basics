import java.util.HashMap;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            map.put(c, 0);
            map.put(c, map.get(c)+1);
        }

        int count = map.size();
        int i=0;
        for(int j=0; j< s2.length(); j++) {
            char c = s2.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) count--;
                if (count == 0) return true;
                if (map.get(c) < 0) {
                    while(map.get(c) != 0) {
                        char ci = s2.charAt(i);
                        if (map.containsKey(ci)) {
                            map.put(ci, map.get(ci)+1);
                            if (map.get(ci) == 1) count++;
                        }
                        i++;
                    }
                }
            }
            else if (!map.containsKey(c)) {
                while(i <=j) {
                    char ci = s2.charAt(i);
                    if (map.containsKey(ci)) {
                        map.put(ci, map.get(ci)+1);
                        if (map.get(ci) == 1) count++;
                    }
                    i++;
                }
            }
        }
        return false;
    }

}
