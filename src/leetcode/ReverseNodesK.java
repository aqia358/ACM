package leetcode;

public class ReverseNodesK {

	public static ListNode reverseKGroup(ListNode head, int k) {
		int size = 0;
		ListNode p = head;
		while(p != null && size < k){
			size++;
			p = p.next;
		}
		if(size < k) return head;
		ListNode prev = reverseKGroup(p, k);
		ListNode next;
		for(int i = 0; i < k; i++){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	public static ListNode reverseKGroup2(ListNode head, int k) {
		ListNode prev = null;
		ListNode next, p;
		p = head;
		int size = 0;
		while(p != null){
			size++;
			p = p.next;
		}
		p = head;
		prev = getNode(head, size/k * k + 1);
		for(int j = size/k; j > 0; j--){
			p = getNode(head, k*(j-1) + 1);
			for(int i = 0; i < k; i++){
				next = p.next;
				p.next = prev;
				prev = p;
				p = next;
			}
		}
		return prev;
	}
	
	public static ListNode getNode(ListNode head, int index){
		while(index > 1){
			index--;
			head = head.next;
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
		ListNode l = reverseKGroup(l1, 2);
	}

}
