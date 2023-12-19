package Tree;
import java.util.Scanner;

public class binary_tree {
	private static class Node{
	int value;
	Node left;
	Node right;
	
	public  Node(int value){
		this.value=value;
	}
	}
private Node root;
public void populate(Scanner scanner) {
	System.out.println("enter the root value:");
	int num=scanner.nextInt();
	root=new Node(num);
	System.out.println("the root is:"+root.value);
	populate(scanner,root);
	
}
private void populate(Scanner scanner,Node node) {
	System.out.println("do you wants to enter the left of (true/false)" +node.value);
	boolean left=scanner.nextBoolean();
	if(left) {
		System.out.println("enter the left value:"+node.value);
		int value=scanner.nextInt();
		node.left=new Node(value);
		populate(scanner,node.left);
		
	}
	System.out.println("do you wants to enter the right of(true/false)" +node.value);
	boolean right=scanner.nextBoolean();
	if(right) {
		System.out.println("enter the right value:"+node.value);
		int value=scanner.nextInt();
		node.right=new Node(value);
		populate(scanner,node.right);
		
	}
}
public void display(){
	display(root);
}
 private void display(Node node){
	if(node==null){
		return;
	}
	System.out.println(node.value);
	display(node.left);
	display(node.right);
	
}
public static void main(String arg[]) {
	Scanner scanner=new Scanner(System.in);
	binary_tree t=new binary_tree();
	t.populate(scanner);
	t.display();
}
}


