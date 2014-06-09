package leetcode;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class DeleteDuplicatesNode {

	public static ListNode deleteDuplicatesNode(ListNode head){
		if(head == null) return null;
		ListNode t = head;
		ListNode h = head;
		int temp;
		while(h != null){
			temp = h.val;
			while(t != null && t.val ==  temp){
				t = t.next;
			}
			h.next = t;
			h = h.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		n1.next = n4;
		n4.next = n2;
		n2.next = n5;
		n5.next = n3;
		deleteDuplicatesNode(n1);
		deleteDuplicatesNode(n4);
		deleteDuplicatesNode(n5);
	}

}
