package leetcode;

public class LinkedCyle {

	public static boolean hasCycle(ListNode head){
		ListNode step1 = head;
		ListNode step2 = head;
		if(head == null || head.next == null)return false;
		while(step1 != null && step2 != null && step2.next != null){
			step1 = step1.next;
			step2 = step2.next.next;
			if(step1 == step2){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		System.out.println(hasCycle(l6));
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(hasCycle(l1));
		l5.next = l1;
		System.out.println(hasCycle(l1));
	}

}
class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		val = x;
		next = null;
	}
}