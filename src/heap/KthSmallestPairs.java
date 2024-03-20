package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getFirst() + b.get(1), a.getFirst() + a.get(1)));
        List<List<Integer>> result = new ArrayList<>();
        for (int value1 : nums1) {
            for (int value2 : nums2) {
                pq.add(new ArrayList<>(Arrays.asList(value1, value2)));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

}
