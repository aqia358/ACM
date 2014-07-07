package leetcode;

public class PartitionList {

	public static ListNode partition(ListNode head, int x) {
		ListNode s = new ListNode(-1);
		ListNode left = s;
		ListNode e = new ListNode(-1);
		ListNode right = e;
		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = left.next;
			} else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		right.next = null;
		left.next = e.next;
		return s.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		partition(l1, 3);
				
	}

}
