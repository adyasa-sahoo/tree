package Tree;
import java.util.Scanner;


public class BST {
    private static class Node {
        private int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BST() {
        this.root = null;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
             node.left=insert(node.left, value);
        } else if (value > node.value) {
             node.right=insert(node.right, value);
        }

        return node;
    }

    public void printInorder() {
        System.out.println("Inorder Traversal:");
        printInorder(root);
        System.out.println();
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.value + " ");
            printInorder(node.right);
        }
    }
   
    private Node inorderprd(Node node) {
    	node=node.left;
    	while(node.right != null) {
    		node=node.right;
    	}
    	Node root=node;
    	node=null;
    	
    	return root;
    	
    }
    public void delete(int num) {
    	delete(root,num);
    	System.out.println("the node is deleted");
    	printInorder();
    }
    private Node delete(Node node,int num){
    	if(node == null) {
    		return null;
    	}
    	if(node.left== null && node.right==null ) {
    		node=null;
    		return null;
    	}
    	if(node.value < num) {
    		node.right=delete(node.right,num);
    	}
    	if(node.value > num) {
    		node.left=delete(node.left,num);
    	}
    	
    	if(node.value == num) {
    		if (node.left == null) {
    			System.out.println(node.right.value);
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
    		System.out.println("got the number");
    		Node pre=inorderprd(root);
    		
    		node.value=pre.value;
    		node.left=delete(node.left,node.left.value);
    		
    		
    	}
    	System.out.println(node.value);
    	return node;
    	
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST tree = new BST();

        System.out.print("Enter the number of nodes in the BST: ");
        int n = scanner.nextInt();

        System.out.println("Enter the values of the nodes:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        tree.printInorder();
        
        System.out.println("enter the node to be deleted:");
        int num=scanner.nextInt();
        tree.delete(num);
      
    }
}
