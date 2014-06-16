package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

	public static ListNode mergeKLists(List<ListNode> lists){
		int s = 0;
		int e = lists.size() - 1;
		return merge(s, e, lists);
	}
	
	public static ListNode merge(int s, int e, List<ListNode> lists){
		if(s == e) return lists.get(s);
		int center = (s + e)/2;
//		merge(s, center, lists);
//		merge(center, e, lists);
		return mergeLists(merge(s, center, lists), merge(center + 1, e, lists));
	}
	public static ListNode mergeLists(ListNode l1, ListNode l2){
		if(l1 == null)return l2;
		if(l2 == null)return l1;
		ListNode result = null;
		if(l1.val > l2.val){
			result = l2;
			result.next =mergeLists(l1, l2.next);
		} else{
			result = l1;
			result.next =mergeLists(l1.next, l2);
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l11 = new ListNode(11);
		ListNode l12 = new ListNode(12);
		ListNode l13 = new ListNode(13);
		ListNode l14 = new ListNode(14);
		ListNode l15 = new ListNode(15);
		ListNode l16 = new ListNode(16);
		ListNode l111 = new ListNode(10);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l14.next = l15;
		l15.next = l16;
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(l1);
		list.add(l11);
		list.add(l111);
		ListNode result = mergeKLists(list);
//		ListNode result = mergeLists(l1, l11);
		System.out.println();
	}

}
