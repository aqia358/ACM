package oj.q1385q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private int[] pre;
	private int[] mid;
	private List<Integer> list = new ArrayList<Integer>();
	
	class Node {
		private Node left;
		private Node right;
		private int data;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	public int find(int data, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (mid[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public Node build(int pIndex, int mStart, int mEnd) {
		if(pIndex >= pre.length)return null;
		int mIndex = find(pre[pIndex], mStart, mEnd);
		if (mIndex == -1 || pIndex + mIndex - mStart + 1 > pre.length) {
			return null;
		}
		if (mStart == mEnd) {
			return new Node(mid[mStart]);
		}
		Node node = new Node(pre[pIndex]);
		node.left = build(pIndex + 1, mStart, mIndex - 1);//左节点
		node.right = build(pIndex + mIndex - mStart + 1, mIndex + 1, mEnd);//右节点
		return node;
	}

	public void postOrder(Node root){
		if(root.left !=null)postOrder(root.left);
		if(root.right != null)postOrder(root.right);
		list.add(root.data);
	}
	public void print(){
		if(pre.length > list.size()){
			System.out.println("No");
		}else{
			for(int i = 0; i < list.size(); i++){
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
	public void run(int n) {
		postOrder(build(0, 0, n - 1));
		print();
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			int count = 0;
			Main m = new Main();
			m.pre = new int[n];
			m.mid = new int[n];
			while(count < n && st.nextToken() != st.TT_EOF)m.pre[count++] = (int)st.nval;
			count = 0;
			while(count < n && st.nextToken() != st.TT_EOF)m.mid[count++] = (int)st.nval;
			m.run(n);
		}
	}
}
