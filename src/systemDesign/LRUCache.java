package systemDesign;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Node structure of doubly linked list
 **/
class DoublyNode<T> {
    DoublyNode<T> prev;
    T value;
    DoublyNode<T> next;

    public DoublyNode(DoublyNode<T> prev, T value, DoublyNode<T> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public DoublyNode(T value) {
        this.prev = null;
        this.value = value;
        this.next = null;
    }
}

/**
 * Operation class of doubly linked list
 **/
class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void add(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (this.tail == null) {
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
        }
        this.head = newNode;
    }

    void removeItemFromTail() {
        // If there is only one node
        if (this.tail.prev == null) {
            this.tail = null;
            this.head = null;
        }

        // If there is more than one node
        if (this.tail != null) {
            DoublyNode<T> temp = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
    }

    public DoublyNode<T> getHead() {
        return this.head;
    }

    public void setHead(DoublyNode<T> head) {
        this.head = head;
    }

    public DoublyNode<T> getTail() {
        return this.tail;
    }

    public void setTail(DoublyNode<T> tail) {
        this.tail = tail;
    }

}

/**
 * This class handles LRUCache operation
 **/
class LRUCache<S, T> {
    private static final int DEFAULT_SIZE = 3;
    private final int cacheSize;
    private final ConcurrentHashMap<S, DoublyNode<T>> cacheMap;
    private final DoublyLinkedList<T> doublyLinkedList;

    public LRUCache() {
        this(DEFAULT_SIZE);
    }

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cacheMap = new ConcurrentHashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    void addItem(S key, T value) {
        this.doublyLinkedList.add(value);
        this.cacheMap.put(key, this.doublyLinkedList.getHead());

        if (this.cacheMap.size() > this.cacheSize) {
            this.cacheMap.remove(this.doublyLinkedList.getTail());
            doublyLinkedList.removeItemFromTail();
        }
    }

    T getItem(S key) {
        DoublyNode<T> usedNode = this.cacheMap.get(key);
        if (this.cacheMap.size() == 1) {
            return usedNode.value;
        }

        DoublyNode<T> prevNode = usedNode.prev;
        DoublyNode<T> nextNode = usedNode.next;

        if (prevNode == null) {
            return usedNode.value;
        }

        if (nextNode == null) {
            prevNode.next = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            prevNode.prev = (prevNode.prev == null) ? usedNode : prevNode.prev;
        }

        usedNode.prev = null;
        usedNode.next = this.doublyLinkedList.getHead();
        this.doublyLinkedList.setHead(usedNode);

        return usedNode.value;
    }
}

/**
 * Driver class to test LRUCache
 **/
class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(3);
        lruCache.addItem("name", "John");
        lruCache.addItem("age", "25");
        lruCache.addItem("city", "New York");
        lruCache.getItem("age");
        lruCache.addItem("is_student", "false");
    }
}
