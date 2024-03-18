package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums, list, result);
            // We need to pop to maintain the state of recursion tree.
            list.remove(list.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

}
