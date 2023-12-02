package queue;

import java.util.Deque;
import java.util.LinkedList;

public class MonotonicQueue {

    public static void main(String[] args) {

        int[] elements = {6, 2, 7, 9};
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < elements.length; i++) {
            while (!queue.isEmpty() && queue.getLast() > elements[i]) {
                queue.removeLast();
            }
            queue.addLast(elements[i]);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.removeFirst());
        }

    }
}
