import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BasicCollectionDataStructures {

    public static void main(String[] args) {

        // --------------------- Heaps ---------------------
        // default PriorityQueue is implemented with Min-Heap, that is the top element is the minimum one in the heap.
        System.out.println("Min Heap");
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(100);
        minHeap.add(99);
        minHeap.add(201);
        minHeap.add(78);

        System.out.println(minHeap);

        minHeap.poll();
        System.out.println(minHeap);

        // change the comparator to make it a max heap
        System.out.println("Max Heap");
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.add(100);
        maxHeap.add(99);
        maxHeap.add(201);
        maxHeap.add(78);

        System.out.println(maxHeap);

        maxHeap.poll();
        System.out.println(maxHeap);

        // --------------------- QUEUE ---------------------
        // use as a queue - LL
        System.out.println("Queue - LL");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(100);
        queue.add(99);
        queue.add(201);
        queue.add(78);

        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        // use as a queue - ArrayDeque
        System.out.println("Queue - ArrayDeque");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(100); // -> addLast - insert at the end
        deque.add(99);
        deque.add(201);
        deque.add(78);

        System.out.println(deque);

        deque.poll(); // -> pollFirst - remove from front
        System.out.println(deque);

        // --------------------- Stack ---------------------
        // stack
        System.out.println("Stack");
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(99);
        stack.push(201);
        stack.push(78);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        // --------------------- Graph ---------------------
        // array of arrayLists - can be used when vertices are numbered 0,1,2...n-1
        int n=3;
        ArrayList<Integer>[] graph1 = new ArrayList[n];
        graph1[0] = new ArrayList<>();
        graph1[1] = new ArrayList<>();
        graph1[2] = new ArrayList<>();

        class Edge{
            int v1;
            int v2;
            int w;
        }
        ArrayList<Edge>[] graph2 = new ArrayList[n];

        // arrayList of arrayLists - any vertices, any edges
        ArrayList<ArrayList<Integer>> graph3 = new ArrayList<ArrayList<Integer>>(n);
    }


}
