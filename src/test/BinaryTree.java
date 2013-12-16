package test;

public class BinaryTree {
	class Node{
		private Node left = null;
		private Node right = null;
		private int data;
		public Node(int data){
			this.data = data;
		}
	}
	
	public void prePrint(Node t){
		System.out.print(t.data);
		if(t.left != null){
			prePrint(t.left);
		}
		if(t.right != null){
			prePrint(t.right);
		}
	}

	public void init(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		root.left = node2;
		node2.left = node4;
		node4.right = node7;
		root.right = node3;
		node3.left = node5;
		node3.right = node6;
		node6.left = node8;
		prePrint(root);
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.init();
		
	}

}
