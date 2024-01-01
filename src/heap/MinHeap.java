package heap;


class MinHeap {
    private final int[] array;
    private final int capacity;
    private int current_heap_size;

    public MinHeap(int n) {
        capacity = n;
        array = new int[capacity];
        current_heap_size = 0;
    }

    // Swapping using reference
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    // Get the Parent index for the given index : (i-1) % 2
    private int parent(int key) {
        return (key - 1) / 2;
    }

    // Get the Left Child index for the given index :  (2 * i) + 1
    private int left(int key) {
        return (2 * key) + 1;
    }

    // Get the Right Child index for the given index : (2 * i) + 2
    private int right(int key) {
        return (2 * key) + 2;
    }


    // Inserts a new key and does heapifyUp
    public boolean insertKey(int key) {
        if (current_heap_size == capacity) {
            return false;
        }

        // First insert the new key at the end
        int i = current_heap_size;
        array[i] = key;
        current_heap_size++;

        // Fix the min heap property if it is violated : heapifyUp
        while (i != 0 && array[i] < array[parent(i)]) {
            swap(array, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    // heapifyDown
    private void MinHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < current_heap_size && array[l] < array[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && array[r] < array[smallest]) {
            smallest = r;
        }

        if (smallest != key) {
            swap(array, key, smallest);
            MinHeapify(smallest);
        }
    }


    // Deletes and returns the root element from the heap
    public int extractMin() {
        // Edge cases when there is not element
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        // Edge cases when there is one element
        if (current_heap_size == 1) {
            current_heap_size--;
            return array[0];
        }

        int root = array[0];
        array[0] = array[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }


}


