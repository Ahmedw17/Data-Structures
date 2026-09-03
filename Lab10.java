public class Lab10 {

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e) {
            element = e;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.element + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail;
        do {
            System.out.print(current.element + " -> ");
            current = current.prev;
        } while (current != tail);
        System.out.println("(back to tail)");
    }

    

    public void addFirst(Object e) {
        Node newest = new Node(e);

        if (isEmpty()) {
            head = tail = newest;
            head.next = head;
            head.prev = head;
        } else {
            newest.next = head;
            newest.prev = tail;
            head.prev = newest;
            tail.next = newest;
            head = newest;
        }
        size++;
    }

    public void addLast(Object e) {
        if (isEmpty()) {
            addFirst(e);
            return;
        }

        Node newest = new Node(e);
        newest.next = head;
        newest.prev = tail;
        tail.next = newest;
        head.prev = newest;
        tail = newest;
        size++;
    }

    public void addNode(int pos, Object e) {
        if (pos <= 0) {
            addFirst(e);
            return;
        }
        if (pos >= size) {
            addLast(e);
            return;
        }

        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }

        Node newest = new Node(e);
        newest.next = current.next;
        newest.prev = current;
        current.next.prev = newest;
        current.next = newest;
        size++;
    }

    

    public void removeFirst() {
        if (isEmpty()) return;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    public void removeNode(Object e) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            if (current.element.equals(e)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                System.out.println("Element " + e + " removed");
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Element " + e + " not found");
    }

  

    public boolean findNode(Object e) {
        if (isEmpty()) return false;

        Node current = head;
        do {
            if (current.element.equals(e))
                return true;
            current = current.next;
        } while (current != head);

        return false;
    }

    

    public void findDuplicate() {
        if (isEmpty()) return;

        Node current = head;
        boolean found = false;

        do {
            Node check = current.next;
            while (check != head) {
                if (current.element.equals(check.element)) {
                    System.out.println("Duplicate found: " + current.element);
                    found = true;
                    break;
                }
                check = check.next;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No duplicates found");
        }
    }

    

    public static void main(String[] args) {
        Lab10 list = new Lab10();

        list.addFirst("CS310");
        list.addLast("CS321");
        list.addLast("CS310");
        list.addNode(1, "CS305");

        list.displayForward();
        list.displayBackward();

        list.findDuplicate();

        list.removeNode("CS305");
        list.displayForward();
    }
}
