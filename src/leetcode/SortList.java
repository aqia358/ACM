package leetcode;

public class SortList {

	public static ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;
		ListNode l = sortList(head);
		ListNode r = sortList(slow);
		return mergesoft(l, r);
	}
	
	public static ListNode mergesoft(ListNode l, ListNode r){
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		while(l != null && r != null){
			while(l != null && r != null && l.val <= r.val){
				temp.next = l;
				temp = l;
				l =  l.next;
			}
			while(l != null && r != null && l.val > r.val){
				temp.next = r;
				temp = r;
				r =  r.next;
			}
		}
		while(l != null){
			temp.next = l;
			temp = l;
			l =  l.next;
		}
		while(r != null){
			temp.next = r;
			temp = r;
			r =  r.next;
		}
		return head.next;
	}
	public static ListNode mergesoft(ListNode l, ListNode r, int start, int center, int end){
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		int rs = center + 1;
		while(start <= center && rs <= end){
			while(start <= center && rs <= end && l.val <= r.val){
				temp.next = l;
				temp = l;
				l =  l.next;
				start++;
			}
			while(start <= center && rs <= end && l.val > r.val){
				temp.next = r;
				temp = r;
				r =  r.next;
				rs++;
			}
		}
		while(start++ <= center){
			temp.next = l;
			temp = l;
			l =  l.next;
		}
		while(rs++ <= end){
			temp.next = r;
			temp = r;
			r =  r.next;
		}
		temp.next = r.next;
		return head.next;
	}
	public static ListNode getNode(ListNode head, int index){
		while(index-- > 0)
			head = head.next;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(21);
		ListNode l12 = new ListNode(13);
		ListNode l13 = new ListNode(55);
		ListNode l14 = new ListNode(37);
		ListNode r1 = new ListNode(2);
		ListNode r2 = new ListNode(4);
		ListNode r3 = new ListNode(6);
		ListNode r4 = new ListNode(8);
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
//		mergesoft(l11, r1);
		r1 = sortList(l11);
	}

}
