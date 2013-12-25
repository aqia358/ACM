package oj.q1368q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Main {
	public static int target;
	
	static class Node{
		public int id;
		public int data;
		public Node left;
		public Node right;
		public Node(int id){
			this.id = id;
		}
	}
	public static Node find(int id, Node node){
		if(node != null){
			if(node.id == id)
				return node;
			Node l = find(id, node.left);
			Node r = find(id, node.right);
			if(l != null){
				return l;
			}else if(r != null){
				return r;
			}else
				return null;
		}else{
			return null;
		}
	}
	public static void search(Node node, Stack<Integer> stack, int sum){
		if(node == null || node.id == -1){
			return;
		}else{
			sum += node.data;
			stack.push(node.id);
			search(node.left, stack, sum);
			search(node.right, stack, sum);
			if(sum == target && node.left.id == -1 && node.right.id == -1){
				System.out.print("A path is found:");
				for(int i:stack){
					System.out.print(" "+i);
				}
				System.out.println();
			}
			stack.pop();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			st.nextToken();
			Main.target = (int)st.nval;
			Node root = new Node(1);
			for(int i = 1; i <= n; i++){
				Node node = Main.find(i, root);
				st.nextToken();
				node.data = (int)st.nval;
				st.nextToken();
				int l = (int)st.nval;
				st.nextToken();
				int r = (int)st.nval;
				if(l > r){
					node.left = new Node(r);
					node.right = new Node(l);
				}else{
					node.left = new Node(l);
					node.right = new Node(r);
				}
			}
			System.out.println("result:");
			Main.search(root, new Stack<Integer>(), 0);
		}
	}

}

//		Node ne = new Node(-1);
//		Node root = new Node(1);
//		root.data = 10;
//		Node node2 = new Node(2);
//		node2.data = 5;
//		Node node3 = new Node(3);
//		node3.data = 12;
//		Node node4 = new Node(4);
//		node4.data = 4;
//		Node node5 = new Node(5);
//		node5.data = 7;
//		root.left = node2;
//		root.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = ne;
//		node3.right = ne;
//		node4.left = ne;
//		node4.right = ne;
//		node5.left = ne;
//		node5.right = ne;
//		Main.target = 22;
//		Main.search(root, new Stack<Integer>(), 0);