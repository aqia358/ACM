package leetcode;

public class AddTwoNumbers {

	public static ListNode addtwoNumbers(ListNode l1, ListNode l2){
		int c = 0;
		int temp;
		ListNode head = l1;
		ListNode prev = null;
		while(l1 != null && l2 != null){
			temp = l1.val + l2.val + c;
			l1.val = temp%10;
			c = temp/10;
			prev = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1 == null){
			prev.next = l2;
			l1 = l2;
		}
		while(l1 != null){
			temp = l1.val + c;
			l1.val = temp%10;
			c = temp/10;
			prev = l1;
			l1 = l1.next;
		}
		if(c > 0) prev.next = new ListNode(c);
		return head;
	}
	public static void main(String[] args) {
		ListNode l0 = new ListNode(9);
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(1);
		ListNode r0 = new ListNode(9);
		ListNode r1 = new ListNode(9);
		ListNode r2 = new ListNode(9);
		l0.next = l1;l1.next = l2;
		r0.next = r1;r1.next = r2;
		addtwoNumbers(l2, r1);
	}

}
