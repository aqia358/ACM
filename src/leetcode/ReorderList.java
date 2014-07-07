package leetcode;

import java.util.Stack;

public class ReorderList {

	public static void reorderList(ListNode head) {
		if(head == null) return;
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
//		if(fast == head) return;
		fast = slow;
		fast = fast.next;
		slow.next = null;
		Stack<ListNode> s = new Stack<ListNode>();
		slow = fast;
		while(slow != null){
			s.push(slow);
			slow = slow.next;
		}
		fast = head;
		ListNode next;
		while(fast.next != null && !s.isEmpty()){
			next = fast.next;
			fast.next = s.pop();
			fast.next.next = next;
			fast = next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
		reorderList(l1);
	}

}
