package leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @author aqia358
 *
 */
public class MergeLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null)return l2;
		if(l2 == null)return l1;
		ListNode result = null;
		if(l1.val < l2.val){
			result = l1;
			result.next = mergeTwoLists(l1.next, l2);
		}else{
			result = l2;
			result.next = mergeTwoLists(l1, l2.next);
		}
		return result;
	}
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
		ListNode temp = null;
		ListNode head = null;
		while(l1 != null && l2 != null){
			while(l1 != null && l2 != null && l1.val <= l2.val){
				if(temp == null){
					head = l1;
					temp = l1;
				} else{
					temp.next = l1;
					temp = temp.next;
				}
				l1 = l1.next;
			}
			while(l1 != null && l2 != null && l2.val < l1.val){
				if(temp == null){
					head = l2;
					temp = l2;
				} else{
					temp.next = l2;
					temp = temp.next;
				}
				l2 = l2.next;
			}
		}
		if(l1 != null){
			if(temp == null){
				head = l1;
				temp = l1;
			} else
				temp.next = l1;
		}
		if(l2 != null)
			if(temp == null){
				head = l2;				
				temp = l2;
			} else
				temp.next = l2;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		l2.next = l3;
		l3.next = l4;
		ListNode t = mergeTwoLists(l1, l2);
	}

}
