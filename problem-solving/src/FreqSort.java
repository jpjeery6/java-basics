import java.util.*;
public class FreqSort {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }


    public static String frequencySort(String s) {
        return solve(s);
    }

    static class Node {
        char c;
        int freq;
        Node prev;
        Node next;

        Node(char c, int f) {
            this.c = c;
            this.freq = f;
        }
    }

    static Node head, tail;
    private static String solve(String s) {
        head = new Node('H', 0);
        tail = new Node('T', 0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;

        Map<Character, Node> map = new HashMap<>();

        for (char i: s.toCharArray()) {
            if (map.containsKey(i)) {
                map.get(i).freq++;
                addToFront(removeNode(map.get(i)));
            } else {
                Node newNode = new Node(i, 1);
                map.put(i, newNode);
                addToEnd(newNode);
            }
        }

        // print
        Node itr = head.next;
        StringBuilder sb = new StringBuilder();
        while(itr != tail) {
            System.out.print(itr.c + " : " + itr.freq + ", ");
            sb.append(itr.c);
            itr = itr.next;
        }
        return sb.toString();
    }

    private static void print() {
        Node itr = head.next;
        while(itr != tail) {
            System.out.print(itr.c + " : " + itr.freq + ", ");
            itr = itr.next;
        }
    }

    private static void addToFront(Node n) {
        Node tmp = head.next;
        head.next = n;
        n.prev = head;
        n.next = tmp;
        tmp.prev = n;
    }

    private static Node removeNode(Node n) {
        Node prv = n.prev;
        Node nxt = n.next;
        prv.next = nxt;
        nxt.prev = prv;
        return n;
    }

    private static void addToEnd(Node n) {
        Node tmp = tail.prev;
        tail.prev = n;
        n.prev = tmp;
        n.next = tail;
        tmp.next = n;
    }

}
