package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    public static void maxHeap(int[] nums) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : nums) {
            pq.add(val);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void minHeap(int[] nums) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void customHeap() {
        int[][] array = {{1, 2}, {1, 3}, {2, 4}, {1, 1}};
        //final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        //PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare( b[0] + b[1],  a[0] + a[1]));

        Collections.addAll(pq, array);

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        maxHeap(arr);
        System.out.println();
        minHeap(arr);
        customHeap();

    }

}
