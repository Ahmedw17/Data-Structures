import java.util.ArrayList;


class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

   
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index) > heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public int delete() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

  
    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

   
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

  
    public void display() {
        System.out.println(heap);
    }
}


class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

 
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    
    public int delete() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

   
    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

   
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

  
    public void display() {
        System.out.println(heap);
    }
}


public class Lab07 {
    public static void main(String[] args) {

        
        System.out.println("=== Max Heap ===");
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(50);
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(35);
        maxHeap.insert(60);

        System.out.print("Max Heap after insertion: ");
        maxHeap.display();

        System.out.println("Deleted root from Max Heap: " + maxHeap.delete());

        System.out.print("Max Heap after deletion: ");
        maxHeap.display();


        
        System.out.println("\n=== Min Heap ===");
        MinHeap minHeap = new MinHeap();

        minHeap.insert(50);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(35);
        minHeap.insert(60);

        System.out.print("Min Heap after insertion: ");
        minHeap.display();

        System.out.println("Deleted root from Min Heap: " + minHeap.delete());

        System.out.print("Min Heap after deletion: ");
        minHeap.display();
    }
}
