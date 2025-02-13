//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//import java.util.UUID;
//
//class Trie {
//
//    TrieNode root;
//
//    Trie() {
//        this.root = new TrieNode<>();
//    }
//
//    static class TrieNode<K, V> {
//        K key;
//        V value;
//        Map<K, TrieNode<K,V>> children = new HashMap<>();
//
//        TrieNode() {
//        }
//        TrieNode(K key) {
//            this.key = key;
//        }
//
//        TrieNode(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        void setValue(V value) {
//            this.value = value;
//        }
//    }
//
//    boolean isLeafNode(TrieNode root) {
//        return root.children.isEmpty();
//    }
//
//    // function to display the content of Trie
//    void display(TrieNode root, Set<TrieNode<K,V> children, int level) {
//        // If node is leaf node, it indicates end
//        // of string, so a null character is added
//        // and string is displayed
//        if (isLeafNode(root)) {
//            for (int k = level; k < str.length; k++)
//                str[k] = 0;
//            System.out.println(str);
//        }
//
//        int i;
//        for (i = 0; i < 26; i++) {
//            // if NON NULL child is found
//            // add parent key to str and
//            // call the display function recursively
//            // for child node
//            if (root.children[i] != null) {
//                str[level] = (char) (i + 'a');
//                display(root.children[i], str, level + 1);
//            }
//        }
//    }
//}
//
//}
//
//public class Tries{
//    public static void main(String[] args) {
//    // char trie
//        Trie trie = new Trie();
//        TrieNode<Character, Character> root = new TrieNode<>();
//        root.insert("/dev/p1/p2/p3");
//        root.insert("/dev/p1/p2/p4");
//        root.insert("/dev/p1/p5/p3");
//
//        root.insert("/sys/p1/p2/p3");
//        root.insert("/sys/p1/p4");
//        root.insert("/sys/p5/p6");
//
//
//    }
//
//}
