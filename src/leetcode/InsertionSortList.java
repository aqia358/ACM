package leetcode;

public class InsertionSortList {

	public static ListNode insertionSortList(ListNode head){
		if(head == null) return null;
		ListNode p = head;
		ListNode prev = null;
		while(p != null){
			if(p.val < head.val){
				prev.next = p.next;
				p.next = head;
				head = p;
				p = prev.next;
			}else{
				prev = p;
				p = p.next;
			}
		}
		head.next = insertionSortList(head.next);
		return head;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode l = insertionSortList(l1);
	}

}
