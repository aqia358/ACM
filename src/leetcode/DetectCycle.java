package leetcode;

public class DetectCycle {

	public static ListNode detectCycle(ListNode head) {
		if(head == null)return null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
	public static ListNode detectCycle2(ListNode head) {
		ListNode t = isCycle(head);
		if(t == null) return null;
		ListNode m = t.next;
		while(m != head){
			while(m != head && m != t){
				m = m.next;
			}
			m = m.next;
			head = head.next;
		}
		return head;
	}
	
	public static ListNode isCycle(ListNode head){
		if(head == null)return null;
		ListNode one = head;
		ListNode two = head;
		while(one != null && two != null){
			if(one == two)
				return one;
			one = one.next;
			if(two.next != null)
				two = two.next.next;
			else
				return null;
		}
		return null;
	}
	public static void main(String[] args) {
		ListNode l = new ListNode(0);
		detectCycle(l);
	}

}
