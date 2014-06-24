package leetcode;

public class ReverseLinkedList {

	public static ListNode reverseBetween(ListNode head, int m, int n){
		ListNode temp = head;
		ListNode rePrev = getNode(temp, m - 1);
		ListNode pre = getNode(temp, n + 1);
		ListNode p = getNode(temp, m);
		ListNode next;
		while(m <= n){
			m++;
			next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		if(rePrev != null){
			rePrev.next = pre;
			return head;
		}else
			return pre;
	}
	
	public static ListNode getNode(ListNode head, int p){
		if(p < 1) return null;
		int i = 1;
		while(i < p){
			head = head.next;
			i++;
		}
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
		l3.next = l4;
		l4.next = l5;
		ListNode t = reverseBetween(l5, 1, 1);
	}

}
