package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int i = 0;
        int res = 0;

        for (int j = 0; j < fruits.length; j++) {
            fruitCount.put(fruits[j], fruitCount.getOrDefault(fruits[j], 0) + 1);
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[i], fruitCount.get(fruits[i]) - 1);

                if (fruitCount.get(fruits[i]) == 0) {
                    fruitCount.remove(fruits[i]);
                }

                i++;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2};
        System.out.println(totalFruit(nums));
    }

}
