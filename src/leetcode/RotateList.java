package leetcode;

public class RotateList {

	public static ListNode rotateRight(ListNode head, int n) {
		if(head == null || n == 0) return head;
		int len = 1;
		ListNode p = head;
		while(p != null && p.next != null){
			len++;
			p = p.next;
		}
		p.next = head;
		n = len - n%len;
		for(int i = 0; i < n; i++)
			p = p.next;
		head = p.next;
		p.next = null;
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		rotateRight(l1, 1);
	}

}
