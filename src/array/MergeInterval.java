package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty()) {
                list.add(intervals[i]);
            } else {
                int[] point1 = list.get(list.size() - 1);
                int[] point2 = intervals[i];
                if (point1[1] >= point2[0]) {
                    list.remove(list.size() - 1);
                    int min1 = Math.min(point1[0], point1[1]);
                    int max1 = Math.max(point1[0], point1[1]);
                    int min2 = Math.min(point2[0], point2[1]);
                    int max2 = Math.max(point2[0], point2[1]);
                    list.add(new int[]{Math.min(min1, min2), Math.max(max1, max2)});
                } else {
                    list.add(point2);
                }
            }
        }
        // Convert the List<int[]> to int[][]
        int[][] mergedIntervals = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            mergedIntervals[i] = list.get(i);
        }
        return mergedIntervals;

    }

    public static void main(String[] args) {
        int[][] num = {{1, 4}, {20, 3}, {4, 5}};
        merge(num);
    }


}



