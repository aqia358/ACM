package lhl.summary.practice.day1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import lhl.summary.Tree;
import lhl.summary.TreeNode;

public class TreeImpl implements Tree {

	public static void main(String[] args) {
		TreeImpl tree = new TreeImpl();
		int[] preorder = {0,1,3,4,2,5,6};
		int[] inorder = {3,1,4,0,5,2,6};
		int[] postorder = {3,4,1,5,6,2,0};
		TreeNode root = tree.buildTreeNodePreInOrder(preorder, inorder);
		tree.postOrder(root);
		tree.postOrderByStack(root);
		System.out.println(tree.depth(root));
	}

	public int find(int[] a, int target){
		for(int i = 0; i < a.length; i++)
			if(a[i] == target)
				return i;
		return  -1;
	}
	
	public TreeNode buildTreeNodePreInOrder(int[] preorder, int[] inorder) {
		return buildTreeNodePreInOrder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public TreeNode buildTreeNodePreInOrder(int[] preorder, int[] inorder, int leftp, int rightp, int left, int right) {
		if(left > right) return null;
		TreeNode root = new TreeNode(preorder[leftp]);
		int p = find(inorder, preorder[leftp]);
		root.left = buildTreeNodePreInOrder(preorder, inorder, leftp + 1, rightp + p - left, left, p - 1);
		root.right = buildTreeNodePreInOrder(preorder, inorder, leftp + p - left + 1, rightp, p + 1, right);
		return root;
	}

	public TreeNode buildTreeNodePostInOrder(int[] inorder, int[] postorder) {
		return null;
	}

	public void preOrder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(TreeNode root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val);
	}

	public void inOrder(TreeNode root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
		
	}

	public void preOrderByStack(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(root != null && !s.isEmpty()){
			while(root != null){
				System.out.print(root.val);
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			root = root.right;
		}
	}

	public void postOrderByStack(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode pre = null;
		do{
			while(root != null){
				s.push(root);
				root = root.left;
			}
			pre = null;
			while(!s.isEmpty()){
				root = s.peek();
				if(root.right == pre) {
					System.out.print(root.val);
					s.pop();
					pre = root;
				} else {
					root = root.right;
					break;
				}
			}
		} while(!s.isEmpty());
	}

	public void inOrderByStack(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(root != null && ! s.isEmpty()) {
			while(root != null){
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			System.out.print(root.val);
			root = root.right;
		}
	}

	public void levelOrder(TreeNode root) {
		if(root == null) return;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			root = q.pop();
			System.out.print(root.val);
			if(root.left != null) q.add(root.left);
			if(root.right != null) q.add(root.right);
		}
	}

	public int minDepth(TreeNode root, int depth) {
		if(root == null) return depth;
		return Math.min(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1));
	}

	public int maxDepth(TreeNode root, int depth) {
		if(root == null) return depth;
		return Math.max(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1));
	}

	public boolean isBalanced(TreeNode root) {
		return depth(root) >= 0;
	}
	
	public int depth(TreeNode root) {
		if(root == null) return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
		return Math.max(left, right) + 1;
	}

	public List<TreeNode> generateTreeNode(int n) {
		return null;
	}

}
