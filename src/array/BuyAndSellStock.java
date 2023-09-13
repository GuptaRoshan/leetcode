package array;

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val : prices) {
            min = Math.min(min, val);
            maxProfit = Math.max(maxProfit, val - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] num = {7, 1, 5, 3, 6, 4};
        maxProfit(num);
    }


}
