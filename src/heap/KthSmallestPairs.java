package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        final PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.get(0) + b.get(1), a.get(0) + a.get(1)));
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
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
