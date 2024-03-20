package concept.comparatorExample;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorVisualization {
    public static void main(String[] args) {
        Integer[] integerValues = new Integer[]{5, 3, 2, 6, 8, 10, 1};
        Comparator<Integer> comparator = (a, b) -> {
            System.out.println(Arrays.toString(integerValues) + " comparing " + a + " and " + b);
            return a.compareTo(b);
        };
        Arrays.sort(integerValues, comparator);
        System.out.println(Arrays.toString(integerValues));
    }
}
