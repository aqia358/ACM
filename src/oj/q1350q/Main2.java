package oj.q1350q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * 2014年3月19日 21:01:58
 * @author aqia358
 *
 */
public class Main2 {

	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value){
			this.value = value;
		}
	}
	public static int max;
	
	public static void getDeep(Node root, int x){
		if(root.left.value != -1){
			getDeep(root.left, x + 1);
		}
		
		if(root.right.value != -1){
			getDeep(root.right, x + 1);
		}
		if(x > max)
			max = x;
	}
	
	public static int treeDeep(Node node){
		if(node == null || node.value == -1)return 0;
		int nLeft = treeDeep(node.left);
		int nRight = treeDeep(node.right);
		return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
	}
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int) st.nval;
			Node root = new Node(1);
			List<Node> list = new ArrayList<Node>();
			list.add(root);
			for(int i = 0; i < n; i ++){
				Node temp = list.get(i);
				st.nextToken();
				temp.left = new Node((int) st.nval);
				list.add(temp.left);
				st.nextToken();
				temp.right = new Node((int) st.nval);
				list.add(temp.right);
			}
//			Main.max = 0;
//			Main.getDeep(root, 1);
//			System.out.println(Main.max);
			System.out.println(Main2.treeDeep(root));
		}
	}

}
