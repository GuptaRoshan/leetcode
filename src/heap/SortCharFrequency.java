package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharFrequency {

    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        int[] charCount = new int[126];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)]++;
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int j = 0; j < charCount.length; j++) {
            if (charCount[j] != 0) {
                queue.add(new int[]{j, charCount[j]});
            }
        }

        while (!queue.isEmpty()) {
            int[] ch = queue.poll();

            for (int i = 0; i < ch[1]; i++) {
                // Converting int to char
                result.append((char) ch[0]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

}
