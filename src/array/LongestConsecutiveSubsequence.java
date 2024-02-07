package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static int longestConsecutiveUsingSet(int[] num) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        //Put all the element into set
        for (int x : num) {
            set.add(x);
        }

        // Loop over all the element
        for (int y : num) {
            int count = 1;

            int temp = y;
            // Start with decreasing order
            while (set.contains(--temp)) {
                count++;
                set.remove(temp);
            }

            temp = y;
            // Start with increasing order
            while (set.contains(++temp)) {
                count++;
                set.remove(temp);
            }

            res = Math.max(res, count);

        }

        return res;
    }


    public static int longestConsecutiveUsingSort(int[] nums) {
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
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveUsingSet(nums));
        System.out.println(longestConsecutiveUsingSort(nums));
    }

}
