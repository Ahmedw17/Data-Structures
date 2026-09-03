class StackArray {
    private int[] stack;
    private int top;
    private int capacity;
    public StackArray(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == capacity - 1);
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        }
        stack[++top] = value;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top--];
    }
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }
    public int size() {
        return top + 1;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    public void makeEmpty() {
        top = -1;
    }
}
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class StackLinkedList {
    private Node top;
    private int size;
    public StackLinkedList() {
        top = null;
        size = 0;
    }
    public boolean isEmpty() {
        return (top == null);
    }
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }
    public int size() {
        return size;
    }
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void makeEmpty() {
        top = null;
        size = 0;
    }
}
public class Lab04 {
    public static void main(String[] args) {
        StackArray S1 = new StackArray(5);
        S1.push(10);
        System.out.println("Top after push: " + S1.top());
        S1.push(20);
        System.out.println("Top after push: " + S1.top());
        S1.push(30);
        System.out.println("Top after push: " + S1.top());
        S1.push(40);
        System.out.println("Top after push: " + S1.top());
        System.out.println("Stack S1 elements:");
        S1.display();
        StackLinkedList S2 = new StackLinkedList();
        while (!S1.isEmpty()) {
            int value = S1.pop();
            S2.push(value);
        }
        System.out.println("Stack S2 elements after transferring:");
        S2.display();
    }
}
