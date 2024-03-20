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
    int SIZE = 10;

    public MyHashMap() {
        map = new Node[SIZE];
        Arrays.fill(map, null);
    }

    public void insert(String key, int value) {
        int hashValue = key.charAt(0) % SIZE;
        Node current = map[hashValue];
        // If there is no collision
        if (current == null) {
            map[hashValue] = new Node(key, value, hashValue, null);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(key, value, hashValue, null);
        }
    }

//    public int get(String key) {
//        int hashValue = key.charAt(0) % SIZE;
//        Node current = map[hashValue];
//
//        if (current){
//
//        }
//    }

//
//    public void remove(String key) {
//        // Implement the remove(k) function.
//    }
//
//    public boolean search(String key) {
//        // Implement the search(k) function.
//    }
//
//    public int getSize() {
//        // Implement the getSize() function.
//    }
//
//    public boolean isEmpty() {
//        // Implement the isEmpty() function.
//    }

}


class Test {
    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        m.insert("key1", 1);
        m.insert("key1", 2);
        m.insert("key1", 3);
    }
}
