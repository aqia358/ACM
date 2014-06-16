package leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * @author aqia358
 *
 */
public class SwapListPair {

	public static ListNode swapPairs(ListNode head){
		if(head == null)return null;
		if(head.next == null)return head;
		ListNode temp = head;
		head = head.next;
		ListNode pre,next;
		pre = temp;
		temp = temp.next;
		next = temp.next;
		temp.next = pre;
		pre.next = swapPairs(next);
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		ListNode temp = swapPairs(l1);
		temp = swapPairs(l1);
		temp = swapPairs(l2);
	}

}
