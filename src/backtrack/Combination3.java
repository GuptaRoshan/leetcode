package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combination3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int start) {

        if (combination.size() > k) {
            return;
        }

        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(result, combination, k, n - i, i + 1);
            combination.remove(combination.size() - 1);
        }


    }

    public static void main(String[] args) {
        int steps = 3;
        int target = 9;
        System.out.println(combinationSum3(steps, target));
    }

}
