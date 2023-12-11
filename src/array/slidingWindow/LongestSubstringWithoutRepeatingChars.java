package array.slidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int startPointer = 0;
        int endPointer = 0;
        int maxLen = 0;

        while (endPointer < s.length()) {
            if (map.containsKey(s.charAt(endPointer))) {
                startPointer = Math.max(startPointer, map.get(s.charAt(endPointer)) + 1);
            }

            map.put(s.charAt(endPointer), endPointer);
            maxLen = Math.max(maxLen, endPointer - startPointer + 1);
            endPointer++;
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringUsingSet(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));
            set.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstringUsingQueue(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringUsingSet("abcc");
    }

}
