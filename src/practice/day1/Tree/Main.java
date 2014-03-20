package practice.day1.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 2014年3月19日 22:28:21
 * 
 * @author aqia358
 *
 */
public class Main {
	
	public static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	public static Node buildTree(){
		Node root = new Node(0);
		Node temp = root;
		temp.left = new Node(1);
		temp.left.left = new Node(3);
		temp.left.right = new Node(4);
		temp.right = new Node(2);
		temp.right.left = new Node(5);
		temp.right.right = new Node(6);
		return root;
	}
	
	public static void levelOrder(Node node){
		List<Node> list = new ArrayList<Node>();
		list.add(node);
		levelPrint(list);
	}
	
	public static void levelPrint(List<Node> list){
		List<Node> lists = new ArrayList<Node>();
		for(Node node : list){
			System.out.print(node.value+" ");
			if(node.left != null)
				lists.add(node.left);
			if(node.right != null)
				lists.add(node.right);
		}
		if(lists.size() > 0)
			levelPrint(lists);
	}
	
	public static void preOrder(Node node){
		if(node != null){
			System.out.print(node.value+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.print(node.value+" ");
			inOrder(node.right);
		}
	}
	
	public static void postOrder(Node node){
		if(node != null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.value+" ");
		}
	}
	public static void main(String[] args) {
		Node tree = Main.buildTree();
		System.out.println();
		Main.preOrder(tree);
		System.out.println();
		Main.inOrder(tree);
		System.out.println();
		Main.postOrder(tree);
		System.out.println();
		levelOrder(tree);
	}

}
