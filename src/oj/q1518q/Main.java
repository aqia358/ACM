package oj.q1518q;

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
 * 反转链表 
 * @author aqia358
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int) st.nval;
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
			if(n <= 0)
				System.out.println("NULL");
			else{
				Node f = first;
				while(f.next.data != -1){
					System.out.print(f.data+" ");
					f = f.next;
				}
				System.out.println(f.data);
			}
		}
	}

}
