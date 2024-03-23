package concept;

import java.util.Arrays;

class Node {
    String Key;
    int value;
    int hashValue;
    Node next;

    public Node(String key, int value, int hashValue, Node next) {
        Key = key;
        this.value = value;
        this.hashValue = hashValue;
        this.next = next;
    }
}


public class MyHashMap {
    Node[] map;
    int SIZE = 26;
    int TOTAL_SIZE = 0;

    public MyHashMap() {
        map = new Node[SIZE];
        Arrays.fill(map, null);
    }

    public void insert(String key, int value) {
        int hashValue = key.charAt(0) % SIZE;
        Node current = map[hashValue];
        // If there is no collision
        if (current == null) {
            TOTAL_SIZE++;
            map[hashValue] = new Node(key, value, hashValue, null);
        } else {
            if (hashValue == current.hashValue) {
                map[hashValue].value = value;
            } else {
                TOTAL_SIZE++;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(key, value, hashValue, null);
            }

        }
    }

    public int get(String key) {
        int hashValue = key.charAt(0) % SIZE;
        Node current = map[hashValue];
        return current.value;
    }


    public void remove(String key) {
        int hashValue = key.charAt(0) % SIZE;
        Node current = map[hashValue];
        if (current.next == null) {
            map[hashValue] = null;
        } else {
            while (current.next != null) {
                current = current.next;
            }
        }
    }

    public boolean search(String key) {
        int hashValue = key.charAt(0) % SIZE;
        Node current = map[hashValue];
        return current != null;
    }

    public int getSize() {
        return TOTAL_SIZE;
    }

    public boolean isEmpty() {
        for (Node node : map) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}


class Test {
    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        System.out.println(m.isEmpty());
        m.insert("a", 1);
        m.insert("b", 2);
        m.insert("c", 3);
        System.out.println(m.getSize());
        System.out.println(m.get("a"));
        System.out.println(m.isEmpty());
    }
}
