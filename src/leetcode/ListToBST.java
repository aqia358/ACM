package leetcode;

import java.util.ArrayList;

public class ListToBST {

	public static TreeNode sortedListToBST(ListNode head){
		int size = 0;
		ListNode temp = head;
		while(temp != null){
			temp = temp.next;
			size++;
		}
		return buildTree(head, 1, size);
	}
	
	public static TreeNode buildTree(ListNode head, int s, int e){
		if(s > e) return null;
		int m = (s + e)/2;
		ListNode temp = getNode(head, m);
		TreeNode root = new TreeNode(temp.val);
		root.left = buildTree(head, s, m - 1);
		root.right = buildTree(head, m + 1, e);
		return root;
	}
	public static ListNode getNode(ListNode head, int index){
		while(index > 1 && head != null){
			head = head.next;
			index--;
		}
		return head;
	}
	public static TreeNode sortedListToBST2(ListNode head){
		if(head == null) return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(head != null){
			list.add(head.val);
			head = head.next;
		}
		int a[] =  {-97,-82,-69,-66,-37,-25,-20,-13,-12,-11,-7,-3,19,33,43,55,77};
		return buildTree(a, 0, a.length - 1);
	}
	public static TreeNode buildTree(int[] a, int s, int e){
		if(s > e) return null;
		int m = (s + e)/2;
		TreeNode treeHead = new TreeNode(a[m]);
		treeHead.left = buildTree(a, 0, m - 1);
		treeHead.right = buildTree(a, m + 1, e);
		return treeHead;
	}
	
	public static void main(String[] args) {
//		TreeNode t = sortedListToBST(new ListNode(3));
//		System.out.print("");
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		TreeNode t = sortedListToBST(l1);
		System.out.println();
	}

}
