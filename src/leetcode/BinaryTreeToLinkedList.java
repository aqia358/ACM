package leetcode;

import java.util.Stack;

public class BinaryTreeToLinkedList {

	public static void flatten(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		while(!s.isEmpty() || root != null){
			while(root != null){
				s.push(root);
//				System.out.print(root.val);
				s2.push(root);
				root = root.left;
			}
			root = s.pop();
//			System.out.print(root.val); //inOrder
			root = root.right;
		}
		TreeNode t = s2.pop();
		t.left = null;
		while(!s2.isEmpty()){
			root = s2.pop();
			root.right = t;
			root.left = null;
			t = root;
		}
	}
	
	public static TreeNode buildLink(TreeNode root, TreeNode tails){
		if(root == null) return tails;
		root.right = buildLink(root.left, buildLink(root.right, tails));
		root.left = null;
		return root;
	}
	public static TreeNode buildLink2(TreeNode root){
		if(root == null) return null;
		TreeNode temp = root;
		TreeNode left = buildLink2(temp.left);
		TreeNode right = buildLink2(temp.right);
		if(left != null){
			temp.right = left;
			while(temp.right != null)
				temp = temp.right;
		}
		if(right != null){
			temp.right = right;
		}
		return root;
	}
	
	public static void preOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(!s.isEmpty() || root != null){
			while(root != null){
				s.push(root);
				System.out.print(root.val);
				root = root.left;
			}
			root = s.pop();
//			System.out.print(root.val); //inOrder
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
		t1.right = t5;
		t2.left = t3;
		t2.right = t4;
		t5.right = t6;
//		flatten(t1);
		TreeNode root = t1;
		preOrder(root);
	}

}
