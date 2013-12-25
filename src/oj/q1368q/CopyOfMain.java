package oj.q1368q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CopyOfMain {
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
	public static void cal(int result, Node node, List<Integer> route){
		result = result+node.data;
		route.add(node.id);
		if(node.id == -1 ||(node.left == null && node.right == null)){
			if(result == target){
				System.out.print("A path is found:");
				for(int a:route){
					System.out.print(" "+a);
				}
				System.out.println();
			}
			return;
		}
		if(node.left != null)
			cal(result,node.left,route);
		if(node.right != null)
			cal(result,node.right,route);
	}
	public static void search(int result, Node root){
		System.out.println("result:");
		target = result;
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.id);
		cal(0, root, new ArrayList<Integer>());
	}
	
	public static void main(String[] args) throws IOException {
//		Main.target = 1;
//		Node root = new Node(1);
//		root.data = 1;
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		Main.cal(1, root, list);
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			st.nextToken();
			CopyOfMain.target = (int)st.nval;
			Node root = new Node(1);
			for(int i = 1; i <= n; i++){
				Node node = CopyOfMain.find(i, root);
				st.nextToken();
				node.data = (int)st.nval;
				st.nextToken();
				int l = (int)st.nval;
				st.nextToken();
				int r = (int)st.nval;
				node.left = new Node(l);
				node.right = new Node(r);
			}
			CopyOfMain.search(target, root);
		}
	}

}
