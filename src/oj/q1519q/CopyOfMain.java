package oj.q1519q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 合并两个排序的链表 
 * @author aqia358
 *
 */
public class CopyOfMain {

	public static void merge(Node a, Node b){
		Node p = new Node(-1);
		Node t;
		while(a.data != -1 && b.data != -1){
			if(a.data > b.data){
				t = new Node(a.data);
				a = a.next;
			}else{
				t = new Node(b.data);
				b = b.next;
			}
			t.next = p;
			p = t;
		}
		while(a.data != -1){
			t = new Node(a.data);
			t.next = p;
			p = t;
			a = a.next;
		}
		while(b.data != -1){
			t = new Node(b.data);
			t.next = p;
			p = t;
			b = b.next;
		}
		while(p.next.data != -1){
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
			Node Mnode = new Node(-1);
			Node Nnode = new Node(-1);
			int count1 = 0;
			int count2 = 0;
			while(count1 < m){
				st.nextToken();
				int t = (int) st.nval;
				Node node = new Node(t);
				node.next = Mnode;
				Mnode = node;
				count1++;
			}
			while(count2 < n){
				st.nextToken();
				int t = (int) st.nval;
				Node node = new Node(t);
				node.next = Nnode;
				Nnode = node;
				count2++;
			}
			if(n + m <= 0)
				System.out.println("NULL");
			else{
				merge(Mnode,Nnode);
			}
		}
	}

}
