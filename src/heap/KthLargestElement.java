package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int k = 3;
        System.out.println(findKthLargest(arr, k));
    }
}
