public class Lab11<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }
    }


    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public Lab11() {
    }

    
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return this.head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return this.tail.getElement();
    }

   
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<E> current = this.head;
        do {
            System.out.print(current.getElement() + " -> ");
            current = current.getNext();
        } while (current != this.head);

        System.out.println("(back to head)");
    }

 
    public void addFirst(E e) {
        if (isEmpty()) {
            this.head = this.tail = new Node<>(e, null);
            this.tail.setNext(this.head);
        } else {
            Node<E> newest = new Node<>(e, this.head);
            this.head = newest;
            this.tail.setNext(this.head);
        }
        this.size++;
    }

    public void addLast(E e) {
        if (isEmpty()) {
            addFirst(e);
        } else {
            Node<E> newest = new Node<>(e, this.head);
            this.tail.setNext(newest);
            this.tail = newest;
            this.size++;
        }
    }

    public void addAtPos(int pos, E e) {
        if (pos <= 0) {
            addFirst(e);
            return;
        }

        if (pos >= this.size) {
            addLast(e);
            return;
        }

        Node<E> current = this.head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.getNext();
        }

        Node<E> newest = new Node<>(e, current.getNext());
        current.setNext(newest);
        this.size++;
    }

   
    public void removeFirst() {
        if (isEmpty()) return;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.tail.setNext(this.head);
        }
        this.size--;
    }

    public void removeNode(E e) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<E> current = this.head;
        Node<E> previous = this.tail;

        do {
            if (current.getElement().equals(e)) {

                if (current == this.head) {
                    removeFirst();
                } else {
                    previous.setNext(current.getNext());
                    if (current == this.tail) {
                        this.tail = previous;
                    }
                    this.size--;
                }

                System.out.println("Element " + e + " removed");
                return;
            }

            previous = current;
            current = current.getNext();

        } while (current != this.head);

        System.out.println("Element " + e + " not found");
    }

    
    public boolean findNode(E e) {
        if (isEmpty()) return false;

        Node<E> current = this.head;
        do {
            if (current.getElement().equals(e)) {
                return true;
            }
            current = current.getNext();
        } while (current != this.head);

        return false;
    }

    
    public void rotate() {
        if (!isEmpty()) {
            this.head = this.head.getNext();
            this.tail = this.tail.getNext();
        }
    }

   
    public static void main(String[] args) {

        Lab11<Object> myList = new Lab11<>();

        myList.addFirst("IAU");
        myList.addFirst(2322);
        myList.addLast("Data Structure");
        myList.addAtPos(2, 7);

        myList.display();

        myList.removeNode("hi");   
        myList.removeNode(7);

        myList.display();

        myList.rotate();
        myList.rotate();

        myList.display();
    }
}
