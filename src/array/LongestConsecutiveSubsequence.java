package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }

        }
        return res;
    }

    public static int longestConsecutive0(int[] num) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int x : num) {
            set.add(x);
        }

        for (int y : num) {
            int count = 1;

            int temp = y;
            while (set.contains(--temp)) {
                count++;
                set.remove(temp);
            }

            temp = y;
            while (set.contains(++temp)) {
                count++;
                set.remove(temp);
            }

            res = Math.max(res, count);

        }

        return res;
    }

    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) set.add(num);

        int max = 1;
        for (int num : nums) {
            if (set.remove(num)) {
                int val = num;
                int sum = 1;
                while (set.remove(val - 1)) val--;

                sum += num - val;

                val = num;
                while (set.remove(val + 1)) val++;

                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }


    public static int longestConsecutive3(int[] nums) {
        int count = 1;
        int res = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive0(nums));
        System.out.println(longestConsecutive1(nums));
        System.out.println(longestConsecutive3(nums));
    }


}
