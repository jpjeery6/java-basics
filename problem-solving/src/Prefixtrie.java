public class Prefixtrie {

    static class Trie {

        class Node {
            Character val;
            boolean isSentinel;
            Node[] child;

            Node(Character val, boolean isSentinel, Node[] child) {
                this.val = val;
                this.isSentinel = isSentinel;
                this.child = child;
            }
            void setIsSentinel(boolean isSentinel) {
                this.isSentinel = isSentinel;
            }
        }

        Node root;

        public Trie() {
            this.root = new Node(null, false, new Node[26]);
        }

        public void insert(String word) {
            insert(0, word, root);
        }

        public void insert(int i, String word, Node itr) {
            if (i == word.length() -1 && itr.child[word.charAt(i) - 'a'] == null) {
                itr.child[word.charAt(i) - 'a'] = new Node(word.charAt(i), true, new Node[26]);
                return;
            }
            else if (i == word.length() -1 && itr.child[word.charAt(i) - 'a'] != null) {
                itr.child[word.charAt(i) - 'a'].setIsSentinel(true);
                return;
            }
            else if (itr.child[word.charAt(i) - 'a'] == null)
                itr.child[word.charAt(i) - 'a'] = new Node(word.charAt(i), false, new Node[26]);
            insert (i+1, word, itr.child[word.charAt(i) - 'a']);
        }


        public boolean search(String word) {
            return search(0, word, root);
        }

        public boolean search(int i, String word, Node itr) {
            if (i == word.length() -1 && itr.child[word.charAt(i) - 'a'] != null &&
                    itr.child[word.charAt(i) - 'a'].isSentinel) return true;
            else if (itr.child[word.charAt(i) - 'a'] == null) return false;

            return search(i+1, word, itr.child[word.charAt(i) - 'a']);
        }

        public boolean startsWith(String prefix) {
            return startsWith(0, prefix, root);
        }

        public boolean startsWith(int i, String prefix, Node itr) {
            if (i == prefix.length() -1 && itr.child[prefix.charAt(i) - 'a'] != null) return true;
            else if (itr.child[prefix.charAt(i) - 'a'] == null) return false;

            return startsWith(i+1, prefix, itr.child[prefix.charAt(i) - 'a']);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("appler"));
        System.out.println("abc");
    }
}
