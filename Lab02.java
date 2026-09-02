import java.util.Objects;

class SinglyLinkedList<E> {
    
   
    private static class Node<E> {
        private E element;
        private Node<E> next;
        
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

 
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

  
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) tail = head;
        size++;
    }

 
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.setNext(newest);
        tail = newest;
        size++;
    }

 
    public void addNode(E e, int index) {
        if (index <= 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) temp = temp.getNext();
            Node<E> newest = new Node<>(e, temp.getNext());
            temp.setNext(newest);
            size++;
        }
    }

   
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) tail = null;
        return answer;
    }

   
    public int findNode(E e) {
        Node<E> curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.getElement().equals(e)) return i;
            curr = curr.getNext();
        }
        return -1;
    }

   
    public void removeNode(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) removeFirst();
        else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) temp = temp.getNext();
            temp.setNext(temp.getNext().getNext());
            if (index == size - 1) tail = temp;
            size--;
        }
    }

 
    public void display() {
        Node<E> curr = head;
        while (curr != null) {
            System.out.print(curr.getElement() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("null");
    }
}


class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + address + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person p) {
            return name.equals(p.name) && address.equals(p.address);
        }
        return false;
    }
}


public class Lab02 {
    public static void main(String[] args) {
        SinglyLinkedList<Person> myPersons = new SinglyLinkedList<>();

        
        myPersons.addFirst(new Person("Khaled", "Dammam"));
        myPersons.addLast(new Person("Noura", "Khobar"));
        myPersons.addNode(new Person("Fahad", "Jubail"), 1);

        System.out.println("Current List:");
        myPersons.display();

       
        System.out.println("Finding Noura index: " + myPersons.findNode(new Person("Noura", "Khobar")));

        
        myPersons.removeFirst();
        myPersons.removeNode(1);

        System.out.println("List after removals:");
        myPersons.display();
    }
}
