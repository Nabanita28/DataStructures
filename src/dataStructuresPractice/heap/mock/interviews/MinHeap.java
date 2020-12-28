package dataStructuresPractice.heap.mock.interviews;


public class MinHeap {
    //initialize
    int size;
    int maxSize;
    int[] heap;
    public static int FRONT = 0;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize];
    }

    //functions to return the parent, left and right child
    public int parent(int pos) {
        return (pos - 1) / 2;
    }

    public int leftChild(int pos) {
        return (2 * pos + 1);
    }

    public int rightChild(int pos) {
        return (2 * pos + 2);
    }

    // Function that returns true if the passed node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    //insert
    public void insert(int element) {
        if (size >= maxSize)
            return;

        heap[size++] = element;
        int current = size - 1;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void swap(int current, int parent) {
        int temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }

    //extract and return the size
    public int extract() {
        int popped = heap[FRONT];
        size--;
        heap[FRONT] = heap[size - 1];
        minHeapify(FRONT);
        return popped;
    }

    //minHeapify
    private void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (heap[leftChild(i)] < heap[i] || heap[rightChild(i)] < heap[i]) {

                if (heap[leftChild(i)] < heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));

                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    // Function to build the min dataStructuresPractice.heap using the minHeapify
    public void buildMinheap() {
        for (int pos = size / 2; pos >= 0; pos--) {
            minHeapify(pos);
        }
    }

    //print
    public void printMinHeap() {
        System.out.println("Min Heap : ");
        for (int i = 0; i <= size / 2; i++) {
            System.out.print("Parent : " + heap[i] + " ");
            System.out.print("Left child : " + heap[2 * i + 1] + " ");
            System.out.print("Right child : " + heap[2 * i + 2] + " ");
            System.out.println();
        }
    }
}
