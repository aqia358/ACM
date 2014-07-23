package lhl.summary.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import lhl.summary.Linkedlist;
import lhl.summary.ListNode;

public class LinkedListImpl implements Linkedlist{

	public static void main(String[] args) {
		LinkedListImpl main = new LinkedListImpl();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode l = main.reverse(l1, 2);
		l = main.mergeSoft(l);
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(5);q.add(2);q.add(1);q.add(3);q.add(4);
		LinkedList<Integer> re = main.quickSort(q);
	}

	public ListNode reverse(ListNode head) {
		if(head == null) return null;
		ListNode prev = null;
		ListNode p = head;
		ListNode next = p.next;
		while(p != null){
			next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		return prev;
	}

	public ListNode reverse(ListNode head, int group) {
		if(head == null) return null;
		ListNode prev, next;
		prev = next = null;
		ListNode p = head;
		for (int i = 0; i < group && p != null; ++i) {
			next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		head.next = reverse(next, group);
		return prev;
	}

	public ListNode reverse(ListNode head, int start, int end) {
		return null;
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode t = new ListNode(-1);
		for(ListNode p = t; list1 != null || list2 != null;) {
			int val1 = (list1 == null) ? Integer.MAX_VALUE : list1.val;
			int val2 = (list2 == null) ? Integer.MAX_VALUE : list2.val;
			if(val1 < val2){
				p.next = list1;
				list1 = list1.next;
			} else {
				p.next = list2;
				list2 = list2.next;
			}
			p = p.next;
		}
		return t.next;
	}
	
	public ListNode mergeSoft(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		ListNode left = mergeSoft(head);
		ListNode right = mergeSoft(fast);
		return merge(left, right);
	}
	
	public ListNode getNode(ListNode head, int i) {
		while(i > 0 && head != null) {
			head = head.next;
			i--;
		}
		return head;
	}

	public LinkedList<Integer> quickSort(LinkedList<Integer> head) {
		linkQSort(head, 0, head.size() - 1);
		return head;
	}
	
	public void linkQSort(LinkedList<Integer> head, int start, int end){
		if(start > end) return;
		int left = start;
		int right = end;
		int key = head.get(left);
		while(left < right) {
			while(left < right && head.get(right) > key)
				right--;
			if(left < right)
				head.set(left, head.get(right));
			while(left < right && head.get(left) <= key)
				left++;
			if(left < right)
				head.set(right, head.get(left));
		}
		head.set(left, key);
		if(left - start > 1)
			linkQSort(head, start, left - 1);
		if(end - right > 1)
			linkQSort(head, left + 1, end);
	}
	
	public void quickSort(int[] a, int left, int right){
		if(left > right) return;
		int start = left;
		int end = right;
		int key = a[start];
		while(start < end){
			while(start < end && a[end] >= key) {
				end--;
			}
			if(start < end)
				a[start] = a[end];
			while(start < end && a[start] < key) {
				start++;
			}
			if(start < end)
				a[end] = a[start];
		}
		a[start] = key;
		if(start - left > 1)
			quickSort(a, left, start - 1);
		if(right - end > 1)
			quickSort(a, end + 1, right);
		
	}
	
	public ListNode quickSort(ListNode head) {
		return null;
	}

	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) return null;
		ListNode fast = head.next.next;
		ListNode slow = head;
		while(fast != slow){
			fast = fast.next.next;
			slow = slow.next;
		}
		slow = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}

	public ListNode findCross(ListNode head1, ListNode head2) {
		int len1,len2;
		len1 = len2 = 0;
		if(len1 < len2) findCross(head2, head1);
		ListNode temp = head1;
		while(temp != null) {
			len1++;
			temp = temp.next;
		}
		temp = head2;
		while(temp != null) {
			len2++;
			temp = temp.next;
		}
		int m = len1 - len2;
		while(m > 0){
			head1 = head1.next;
			m--;
		}
		while(head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}

	public ListNode detectCross(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) return null;
		ListNode fast = head.next.next;
		ListNode slow = head;
		while(fast != slow){
			fast = fast.next.next;
			slow = slow.next;
		}
		slow = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

}
