package practice.day1.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	public static void preOrderByStack(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || root != null){
			while(root != null) {
				stack.add(root);
				System.out.print(root.value+" ");
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		System.out.println();
	}
	
	public static void preOrder(Node node){
		if(node != null){
			System.out.print(node.value+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void inOrderByStack(Node node) {
		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty() || node != null) {
			while(node != null) {
				s.add(node);
				node = node.left;
			}
			node = s.pop();
			System.out.print(node.value + " ");
			node = node.right;
		}
		System.out.println();
	}

	public static void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.print(node.value+" ");
			inOrder(node.right);
		}
	}
	
	public static void postOrderByStack(Node node) {
		Stack<Node> s = new Stack<Node>();
		do{
			while(node != null){
				s.add(node);
				node = node.left;
			}
			Node pre = null;
			while(!s.isEmpty()){
				node = s.peek();
				if(node.right == pre) {
					System.out.print(node.value+" ");
					pre = s.pop();
				} else {
					node = node.right;
					break;
				}
			}
		} while(!s.isEmpty());
		System.out.println();
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
		preOrderByStack(tree);
		Main.inOrder(tree);
		System.out.println();
		inOrderByStack(tree);
		Main.postOrder(tree);
		System.out.println();
		postOrderByStack(tree);
		levelOrder(tree);
	}

}
