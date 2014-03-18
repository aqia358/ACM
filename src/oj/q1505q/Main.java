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

	class Node{
		int value;
		Node next;
	}
	public static void find(int[] a, int[] b){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b.length; j++){
				if(a[i] == b[j]){
					System.out.println(a[i]);
					return;
				}
			}
		}
		System.out.println("My God");
	}
	public static void main(String[] args) throws IOException {
//		int[] a = {1,2,3,6,7};
//		int[] b = {4,5,6,7};
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int m = (int) st.nval;
			st.nextToken();
			int n = (int) st.nval;
			Node a = new Node();
			Node b = new Node();
			for(int i = 0; i < m; i++){
				st.nextToken();
				a.value = (int) st.nval;
				a.next = new Node();
				a = a.next;
			}
			for(int j = 0; j < n; j++){
				st.nextToken();
				b[j] = (int) st.nval;
			}
			Main.find(a, b);
		}
	}

}
