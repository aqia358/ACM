package oj.q1505q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 两个链表的第一个公共结点
 * 2014年3月17日 22:09:38
 * @author aqia358
 *
 */
public class Main {

	static class Node{
		public int value;
		public Node next = null;
	}
	public static void find(Node a, Node b, int m, int n){
		Node l = new Node();
		Node s = new Node();
		int p = 0;
		if(m > n){
			l = a;
			s = b;
			p = m - n;
		}else{
			l = b;
			s = a;
			p = n - m;
		}
		while(p > 0){
			p--;
			l = l.next;
		}
		while(l.next != null && l.value != s.value){
			l = l.next;
			s = s.next;
		}
		if(l.next == null)
			System.out.println("My God");
		else
			System.out.println(l.value);
	}
	
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int m = (int) st.nval;
			st.nextToken();
			int n = (int) st.nval;
			Node a = new Node();
			Node a1 = a;
			Node b = new Node();
			Node b1 = b;
			for(int i = 0; i < m; i++){
				st.nextToken();
				a1.value = (int) st.nval;
				a1.next = new Node();
				a1 = a1.next;
			}
			for(int j = 0; j < n; j++){
				st.nextToken();
				b1.value = (int) st.nval;
				b1.next = new Node();
				b1 = b1.next;
			}
			Main.find(a, b, m, n);
		}
	}

}
