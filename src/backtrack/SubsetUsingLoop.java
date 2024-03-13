package backtrack;

public class SubsetUsingLoop {

    /**
     * Any set containing n elements has 2^n subsets.
     **/
    public static void generateSubsets(int[] number) {
        int n = number.length;
        for (int i = 0; i < Math.pow(2, n); i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(number[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        generateSubsets(new int[]{1, 2, 3});
    }
}
