package practice.day1.link;

import java.security.KeyStore.Builder;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static Node build(List<Node> lists){
		Node head = null;
		for(int i = lists.size() - 1; i >= 0; --i){
			Node temp = lists.get(i);
			temp.next = head;
			head = temp;
		}
		return head;
	}
	public static void main(String[] args) {
		List<Node> lists = new ArrayList<Node>();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		lists.add(n1);
		lists.add(n2);
		lists.add(n3);
		lists.add(n4);
		lists.add(n5);
		
		Node head = build(lists);
		while(head != null){
			System.out.print(head.value);
			head = head.next;
		}
	}

}
class Node{
	public int value;
	public Node next;
	
	public Node(int value){
		this.value = value;
	}
}