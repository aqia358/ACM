package oj.q1523q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * 21时47分07秒
 * @author aqia358
 *
 */
public class Main {
	public static int count ;

	static class Node{
		public int data;
		public Node left = null;
		public Node right = null;
		
		public Node(int data){
			this.data = data;
		}
		
	}
	public static Node find(int data,Node node){
		if(node != null){
			if(node.data == data)
				return node;
			else{
				Node nodel = find(data, node.left);
				Node noder = find(data, node.right);
				if(nodel != null)
					return nodel;
				else if(noder != null)
					return noder;
				else 
					return null;
			}
		}else{
			return null;
		}
	}
	public static void doPrint(Node node){
		List<Node> list = new ArrayList<Node>();
		list.add(node);
		print(list);
		System.out.println();
	}
	public static void print(List<Node> list){
		if(list != null && list.size() > 0){
			List<Node> son = new ArrayList<Node>();
			for(Node node:list){
				if(node != null){
					System.out.print(node.data);
					if(count != 1){
						count--;
						System.out.print(" ");
					}
					son.add(node.left);
					son.add(node.right);
				}
			}
			print(son);
		}
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				st.nextToken();
				a[i] = (int) st.nval;
			}
			Node root = new Node(a[0]);
			for(int j = 1;j <= n; j++){
				st.nextToken();
				String op = st.sval;
				Node node = Main.find(a[j - 1], root);
				if(op.equals("d")){
					st.nextToken();
					int left = (int)st.nval;
					st.nextToken();
					int right = (int)st.nval;
					node.left = new Node(a[left - 1]);
					node.right = new Node(a[right - 1]);
				}else if(op.equals("l")){
					st.nextToken();
					int left = (int)st.nval;
					node.left = new Node(a[left - 1]);
				}else if(op.equals("r")){
					st.nextToken();
					int right = (int)st.nval;
					node.right = new Node(a[right - 1]);
				}
			}
			Main.count = n;
			Main.doPrint(root);
		}
	}

}
