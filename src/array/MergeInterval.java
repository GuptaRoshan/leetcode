package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] lastInterval = list.get(list.size() - 1);
            int[] currInterval = interval;
            if (lastInterval[1] >= currInterval[0]) {
                list.remove(list.size() - 1);
                list.add(new int[]{lastInterval[0], Math.max(lastInterval[1], currInterval[1])});
            } else {
                list.add(currInterval);
            }
        }

        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {
        int[][] num = {{1, 4}, {20, 3}, {4, 5}};
        System.out.println(merge(num));
    }

}






