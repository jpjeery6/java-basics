import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestA {

    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        List<List<String>> res = new ArrayList<>();

        for (String q: queries) {
            List<String> anagrams = findAnagrams(q, words);
            res.add(anagrams);
        }

        return res;
    }

    private static List<String> findAnagrams(String word, List<String> words) {
        List<String> anagrams = new ArrayList<>();
        for (String w: words) {
            if (isAnagram(word, w)) anagrams.add(w);
        }
        return anagrams;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        HashMap<Character, Integer> freq = new HashMap<>();
        System.out.println(a + "," +b);

        for (int i=0; i< a.length(); i++) {
            if (freq.containsKey(a.charAt(i))) freq.put(a.charAt(i), freq.get(a.charAt(i))+1);
            else freq.put(a.charAt(i), 1);
        }

        for (int i=0; i< b.length(); i++) {
            if (freq.containsKey(b.charAt(i))) freq.put(b.charAt(i), freq.get(b.charAt(i))-1);
            else return false;
        }

        for (Character c: freq.keySet()) {
            if (freq.get(c) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        getSearchResults(Arrays.asList("duel","speed","dule","cars"), Arrays.asList("spede","deul"));
    }
}
