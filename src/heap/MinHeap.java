package heap;


class MinHeap {
    private final int[] heap;
    private final int capacity;
    private int currentHeapCapacity;

    public MinHeap(int n) {
        capacity = n;
        heap = new int[capacity];
        currentHeapCapacity = 0;
    }


    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    // Get the Parent index for the given index : (i-1) / 2
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

    // ----------------------------------------------------------------------//

    /**
     * 1. Insert the new key at the end
     * 2. Fix the min heap property if it is violated : heapify Up
     */
    public boolean insertKey(int key) {
        // Edge case when the heap is full
        if (currentHeapCapacity == capacity) {
            return false;
        }
        //Insert the new key at the end
        int i = currentHeapCapacity;
        heap[i] = key;
        currentHeapCapacity++;

        // Fix the min heap property if it is violated : heapify Up
        // Last element index is i
        heapifyUp(heap, i);
        return true;
    }

    // heapifyUp Iterative
    // heapifyUp is used during insertion of a new element in the heap
    public void heapifyUp(int lastElementIndex) {
        int parentIndex = this.parent(lastElementIndex);
        while (lastElementIndex != 0 && heap[lastElementIndex] < heap[parentIndex]) {
            swap(heap, lastElementIndex, parentIndex);
            lastElementIndex = parentIndex;
        }
    }

    // heapifyUp Recursive
    public void heapifyUp(int[] array, int index) {
        // Base case: Reached the root
        if (index == 0) {
            return;
        }
        // Calculate parent index
        int parentIndex = this.parent(index);
        // If child is smaller than parent
        if (array[index] < array[parentIndex]) {
            // Swap values
            this.swap(array, index, parentIndex);
            // Recursively heapify-up the parent
            heapifyUp(array, parentIndex);
        }
    }

    // ----------------------------------------------------------------------//

    // Replace the last element with root, and delete it.
    // Fix the min heap property if it is violated : heapify Down
    public int extractMin() {
        // Edge cases when there is no element
        if (currentHeapCapacity <= 0) {
            return Integer.MAX_VALUE;
        }
        // Edge cases when there is one element
        else if (currentHeapCapacity == 1) {
            currentHeapCapacity--;
            return heap[0];
        }

        // Swap the root with the last element
        int root = heap[0];
        heap[0] = heap[currentHeapCapacity - 1];
        currentHeapCapacity--;
        heapifyDown(heap,0);

        return root;
    }

    // heapifyDown Iterative
    private void heapifyDown(int index) {
        while (index < currentHeapCapacity) {
            int smallest = index;
            int leftChild = left(index);
            int rightChild = right(index);

            if (leftChild < currentHeapCapacity && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < currentHeapCapacity && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }
            if (smallest != index) {
                swap(heap, index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }


    // heapifyDown Recursive
    private void heapifyDown(int[] array, int index) {
        int l = left(index);
        int r = right(index);

        int smallest = index;
        if (l < currentHeapCapacity && array[l] < array[smallest]) {
            smallest = l;
        }
        if (r < currentHeapCapacity && array[r] < array[smallest]) {
            smallest = r;
        }
        if (smallest != index) {
            swap(array, index, smallest);
            heapifyDown(array, smallest);
        }
    }

}

class Test {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insertKey(10);
        minHeap.insertKey(20);
        minHeap.insertKey(15);
        System.out.println(minHeap.extractMin()); // 10
        System.out.println(minHeap.extractMin()); // 15
        minHeap.insertKey(20);
        minHeap.insertKey(100);
        System.out.println(minHeap.extractMin()); // 20
    }
}


