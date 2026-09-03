class QueueLinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        public E getData() { return data; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> next) { this.next = next; }
        @Override
        public String toString() { return data + ""; }
    }

    private Node<E> front = null; 
    private Node<E> rear = null;  
    private int size = 0;         

    public boolean isEmpty() { return size == 0; } 

    public void enQueue(E value) { 
        Node<E> newNode = new Node<>(value, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
        System.out.println(value + " Added to Queue"); 
    }

    public Node<E> deQueue() { 
        if (isEmpty()) return null;
        Node<E> temp = front;
        front = front.getNext();
        size--;
        if (size == 0) rear = null;
        System.out.println(temp.getData() + "- Deleted from Queue"); 
        return temp;
    }

    public void display() { 
        if (isEmpty()) return;
        System.out.println("****** Display Queue ********"); 
        Node<E> curr = front;
        while (curr != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }
}


class QueueDoubleEnded<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next, prev; 

        Node(E data, Node<E> next, Node<E> prev) { 
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> front = null, rear = null; 
    private int size = 0; 

    public boolean isEmpty() { return size == 0; } 

    
    public void enQueueFront(E value) {
        Node<E> newNode = new Node<>(value, null, null);
        if (isEmpty()) {
            front = rear = newNode;
            newNode.next = newNode.prev = front;
        } else {
            newNode.next = front;
            newNode.prev = rear;
            front.prev = newNode;
            rear.next = newNode;
            front = newNode;
        }
        size++;
        System.out.println(value + " Added to Queue (enQueueFront)"); 
    }

   
    public void enQueueRear(E value) {
        Node<E> newNode = new Node<>(value, null, null); 
        if (isEmpty()) {
            front = rear = newNode; 
            newNode.next = newNode.prev = front; 
        } else {
            newNode.prev = rear; 
            rear.next = newNode; 
            front.prev = newNode; 
            newNode.next = front; 
            rear = newNode; 
        }
        size++;
        System.out.println(value + " Added to Queue (enQueueRear)"); 
    }

    
    public Node<E> deQueueFront() {
        if (isEmpty()) return null;
        Node<E> temp = front; 
        if (size == 1) {
            front = rear = null; 
        } else {
            front = front.next; 
            rear.next = front; 
            front.prev = rear; 
        }
        size--;
        System.out.println(temp.data + "- Deleted from Queue (deQueueFront)"); 
        return temp;
    }

    
    public Node<E> deQueueRear() {
        if (isEmpty()) return null;
        Node<E> temp = rear;
        if (size == 1) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = front;
            front.prev = rear;
        }
        size--;
        System.out.println(temp.data + "- Deleted from Queue (deQueueRear)"); 
        return temp;
    }

    public void display() { 
        if (isEmpty()) return;
        System.out.println("\n********** Display Queue **************"); 
        Node<E> current = front;
        do {
            System.out.println(current.data); 
            current = current.next; 
        } while (current != front); 
        System.out.println("***************************************\n"); 
    }
}


public class Lab09 {
    public static void main(String[] args) {
        
        System.out.println("Testing a Queue using Linear Linked List:");
        QueueLinkedList<Integer> q1 = new QueueLinkedList<>();
        q1.enQueue(10); 
        q1.enQueue(20); 
        q1.enQueue(30); 
        q1.enQueue(40); 
        q1.display();   
        q1.deQueue();   
        q1.deQueue();   
        
        System.out.println("\n---------------------------------------\n");

        
        System.out.println("Testing a Double Ended Queue using CDLL:");
        QueueDoubleEnded<Integer> q2 = new QueueDoubleEnded<>();
        q2.enQueueFront(10); 
        q2.enQueueFront(20); 
        q2.enQueueFront(30); 
        q2.enQueueFront(40); 
        q2.enQueueRear(50);  
        q2.enQueueRear(60);  
        
        q2.deQueueFront();   
        q2.deQueueRear();    
        
        q2.display(); 
    }
}
