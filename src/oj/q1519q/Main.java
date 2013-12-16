package oj.q1519q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class Node{
	public int data;
	public Node next;
	public Node(int data){
		this.data = data;
	}
}
/**
 * 合并两个排序的链表 
 * @author aqia358
 *
 */
public class Main {

	public static void merge(Node a, Node b){
		Node p;
		if(a.data > b.data){
			p = new Node(b.data);
			b = b.next;
		} else{
			p = new Node(a.data);
			a = a.next;
		}
		Node t = p;
		while(a.next != null && b.next != null){
			if(a.data > b.data){
				t.next = b;
				b = b.next;
			}else{
				t.next = a;
				a = a.next;
			}
			t = t.next;
		}
		while(a.next != null){
			t.next = a;
			a = a.next;
		}
		while(b.next != null){
			t.next = b;
			b = b.next;
		}
		while(p.next != null){
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println(p.data);
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int m = (int) st.nval;
			st.nextToken();
			int n = (int) st.nval;
			st.nextToken();
			Node end = new Node(-1);
			Node a = new Node((int) st.nval); 
			Node Mnode = a;
			int count1 = 1;
			while(count1 < m){
				st.nextToken();
				int t = (int) st.nval;
				Node node = new Node(t);
				Mnode.next = node;
				Mnode = node;
				count1++;
			}
			Mnode.next = end;
			st.nextToken();
			Node b = new Node((int) st.nval);
			Node Nnode = b;
			int count2 = 1;
			while(count2 < n){
				st.nextToken();
				int t = (int) st.nval;
				Node node = new Node(t);
				Nnode.next = node;
				Nnode = node;
				count2++;
			}
			Nnode.next = end;
			if(n + m <= 0)
				System.out.println("NULL");
			else{
				merge(a,b);
			}
		}
	}

}
