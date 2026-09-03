class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    private BinaryTreeNode parent;

    public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
}

class BinarySearchTree {
    private BinaryTreeNode root;

    public BinarySearchTree() {
        root = null;
    }

   
    public void insert(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value, null, null, null);

        if (root == null) {
            root = newNode;
            return;
        }

        BinaryTreeNode current = root;
        BinaryTreeNode parent = null;

        while (current != null) {
            parent = current;

            if (value < current.getValue())
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }

        newNode.setParent(parent);

        if (value < parent.getValue())
            parent.setLeftChild(newNode);
        else
            parent.setRightChild(newNode);
    }

 
    public BinaryTreeNode find(int value) {
        BinaryTreeNode current = root;

        while (current != null) {
            if (value == current.getValue())
                return current;
            else if (value < current.getValue())
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }

        return null;
    }

    
    public void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRightChild());
        }
    }

   
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

  
    public void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }

   
    public int findMax() {
        BinaryTreeNode current = root;

        while (current.getRightChild() != null)
            current = current.getRightChild();

        return current.getValue();
    }

  
    public int findMin() {
        BinaryTreeNode current = root;

        while (current.getLeftChild() != null)
            current = current.getLeftChild();

        return current.getValue();
    }

    
    public int findDepth(BinaryTreeNode node) {
        int depth = 0;

        while (node != root) {
            node = node.getParent();
            depth++;
        }

        return depth;
    }

    
    public int findHeight(BinaryTreeNode node) {
        if (node == null)
            return -1;

        int leftHeight = findHeight(node.getLeftChild());
        int rightHeight = findHeight(node.getRightChild());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }
}

public class Lab06{
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("InOrder: ");
        tree.inOrder(tree.getRoot());

        System.out.println("\nMaximum Value: " + tree.findMax());
        System.out.println("Minimum Value: " + tree.findMin());

        BinaryTreeNode node = tree.find(30);

        System.out.println("Depth of node 30: " + tree.findDepth(node));
        System.out.println("Height of node 30: " + tree.findHeight(node));
    }
}
