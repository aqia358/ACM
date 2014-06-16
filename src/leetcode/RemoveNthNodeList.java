package leetcode;

public class RemoveNthNodeList {

	public static ListNode removeNthFromEnd(ListNode head, int n){
		ListNode fast = head;
		ListNode slow = null;
		int size = 0;
		for(int i = 0; i < n; i ++){
			size++;
			fast = fast.next;
		}
		while(fast != null){
			size++;
			if(slow == null)
				slow = head;
			else
				slow = slow.next;
			fast = fast.next;
		}
		if(size < n)
			return null;
		else if(size == n)
			return head.next;
		else{
			slow.next = slow.next.next;
			return head;
		}
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
		ListNode r = removeNthFromEnd(l1, 1);
		while(r != null){
			System.out.print(r.val);
			r = r.next;
		}
	}

}
