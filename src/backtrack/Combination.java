package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), result, target, 0);
        return result;
    }

    public static void backtrack(int[] candidates, List<Integer> list, List<List<Integer>> result, int rem, int start) {
        if (rem < 0) {
            return;
        }

        if (rem == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, list, result, rem - candidates[i], i);
            list.remove(list.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));
    }
}
