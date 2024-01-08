package Tree;
import java.util.Scanner;

public class AVL {
    private static class Node {
        private int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
            this.height = 1;
        }
    }

    public Node root;

    public AVL() {
        this.root = null;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            
            return node;
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalance(node);

        // Left-Left case
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }
        // Right-Right case
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }
        // Left-Right case
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // Right-Left case
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void printPreorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVL tree = new AVL();
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 17);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 53);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 19);
        tree.root = tree.insert(tree.root, 16);
        tree.root = tree.insert(tree.root, 20);
        tree.printPreorder(tree.root);
    }
}
