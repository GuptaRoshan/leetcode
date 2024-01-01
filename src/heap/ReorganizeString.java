package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {

    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Queue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        while (queue.size() >= 2) {
            Character ch1 = queue.poll();
            Character ch2 = queue.poll();
            result.append(ch1);
            result.append(ch2);
            map.put(ch1, map.get(ch1) - 1);
            map.put(ch2, map.get(ch2) - 1);

            if (map.get(ch1) > 0) {
                queue.add(ch1);
            }
            if (map.get(ch2) > 0) {
                queue.add(ch2);
            }
        }

        if (queue.size() == 0) {
            return result.toString();
        }

        Character ch = queue.poll();
        if (map.get(ch) > 1) {
            return "";
        }

        return result.append(ch).toString();
    }

    public static void main(String[] args) {
        String s = "abbabbaaab";
        System.out.println(reorganizeString(s));

    }

}
