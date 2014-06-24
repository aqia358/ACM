package leetcode;

public class RemoveDupFromList {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head.next;
		if(p != null && p.val == head.val){
			while(p != null && p.val == head.val){
				p = p.next;
			}
			return deleteDuplicates(p);
		}else{
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode l = deleteDuplicates(l1);
	}

}
