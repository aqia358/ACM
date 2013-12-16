package oj.q1517q;

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
 * 
 * 链表中倒数第k个结点
 * @author aqia358
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int) st.nval;
			st.nextToken();
			int num = (int) st.nval;
			Node first = new Node(-1);
			int count = 0;
			while(count < n){
				st.nextToken();
				int t = (int) st.nval;
				Node node = new Node(t);
				node.next = first;
				first = node;
				count++;
			}
			if(num > n)
				System.out.println("NULL");
			else{
				Node f = first;
				while(num > 1){
					f = f.next;
					num--;
				}
				System.out.println(f.data);
			}
		}
	}

}
