package concept.input;

import java.util.*;

public class CollectionInput {

    public static void main(String[] args) {
        // ArrayList Operations
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(0);
        list.remove(0);
        list.add(0, 4);
        list.size();

        // HashSet Operations
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(5);
        set.remove(3);
        set.size();

        // Stack Operations
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.pop();
        stack.size();

        // LinkedList Operations
        LinkedList<Integer> linkedlist = new LinkedList<>();
        // Append in the linkedList
        linkedlist.add(1);
        linkedlist.addFirst(2);
        linkedlist.addLast(3);
        linkedlist.getFirst();
        linkedlist.getLast();
        linkedlist.size();

        // Queue Operations
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        queue.add(5);
        queue.poll();

        // Creating a Deque using LinkedList
        Deque<String> deque = new LinkedList<>();
        deque.addLast("Element 1");
        deque.addLast("Element 2");
        deque.addFirst("Element 3");
        deque.pollFirst();
        deque.pollLast();

        // Priority Queue
        // Ascending Comparator
        Queue<Integer> priorityQueueAscending = new PriorityQueue<>((a, b) -> a - b);
        // Ascending Comparator
        Queue<Integer> priorityQueueDescending = new PriorityQueue<>((a, b) -> b - a);

        //HashMap Operations
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Key1", "Value1");
        hashMap.put("Key2", "Value2");
        hashMap.get("Key2");
        hashMap.getOrDefault("Key2", "value3");
        hashMap.containsKey("Key3");
        hashMap.remove("Key1");
        hashMap.size();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }
}
