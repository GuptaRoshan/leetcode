package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));

    }
}
