package backtrack;

import java.util.Arrays;

public class BackTrackExample {

    public static void subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums);
    }

    private static void backtrack(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
    }

}
