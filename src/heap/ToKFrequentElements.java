package heap;

import java.util.*;

public class ToKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[k];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            queue.add(new int[]{key, value});
        }
        int index = 0;
        while (!queue.isEmpty() && index < k) {
            int[] temp = queue.poll();
            result[index] = temp[0];
            index++;
        }

        return result;
    }

    public static List<Integer> topKFrequent_BucketSort(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
