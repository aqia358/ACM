package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTPostOrder {

	public static List<Integer> postOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postOrder(root, list);
		return list;
	}

	public static void postOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}

	public static void preOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			root = s.pop();
			System.out.print(root.val);
			if (root.right != null)
				s.push(root.right);
			if (root.left != null)
				s.push(root.left);
			root = root.left;
		}
	}

	public static void inOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(root != null){
			s.push(root);
			root = root.left;
		}
		while(!s.isEmpty()) {
			root = s.pop();
			System.out.print(root.val);
			root = root.right;
			while(root != null){
				s.push(root);
				root = root.left;
			}
		}
	}

	public static void postOrder2(TreeNode root) {
		int[] a = new int[1000];
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (root != null) {
			s.push(root);
			root = root.left;
		}
		while (!s.isEmpty()) {
			if(a[s.size()] == 0){
				root = s.peek();
				a[s.size()] = 1;
				root = root.right;
				while (root != null) {
					s.push(root);
					root = root.left;
				}
			}else{
				root = s.pop();
				System.out.print(root.val);
			}
		}
	}	
	
	public static void postOrderStack(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int[] a = new int[20];
		while(root != null){
			stack.push(root);
			a[stack.size()] = 0;
			root = root.left;
		}
		while(!stack.isEmpty()){
			root = stack.peek();
			while(root != null && root.right != null && a[stack.size()] == 0){
				a[stack.size()] = 1;
				root = root.right;
				while(root != null){
					stack.push(root);
					a[stack.size()] = 0;
					root = root.left;
				}
			}
			root = stack.pop();
			System.out.print(root.val);
		}
	}
	
	public static void preOrderStack(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(root != null || !s.isEmpty()){
			while(root != null){
				s.push(root);
				System.out.print(root.val);//pre order
				root = root.left;
			}
			root = s.pop();
//			System.out.print(root.val);//in order
			root = root.right;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
//		postOrder(t1);
//		preOrder(t1);
//		System.out.println();
//		inOrder(t1);
//		System.out.println();
//		postOrder2(t1);
//		System.out.println();
		postOrderStack(t1);
	}

}
