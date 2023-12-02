package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] used) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue; // to skip duplicates

            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, result, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permuteUnique(nums));
    }

}
