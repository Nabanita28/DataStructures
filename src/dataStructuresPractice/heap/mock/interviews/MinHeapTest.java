package dataStructuresPractice.heap.mock.interviews;

public class MinHeapTest {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.buildMinheap();
        minHeap.printMinHeap();
        System.out.println(minHeap.parent(3));
        System.out.println(minHeap.extract());
        System.out.println(minHeap.extract());
    }
}
