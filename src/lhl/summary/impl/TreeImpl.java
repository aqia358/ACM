package lhl.summary.impl;

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
		TreeNode t0 = tree.buildTreeNodePostInOrder(inorder, postorder);
		System.out.println("preorder test");
		tree.preOrder(t0);
		System.out.println();
		tree.preOrderByStack(t0);
		System.out.println();
		System.out.println("inorder test");
		tree.inOrder(t0);
		System.out.println();
		tree.inOrderByStack(t0);
		System.out.println();
		System.out.println("postorder test");
		tree.postOrder(t0);
		System.out.println();
		tree.postOrderByStack(t0);
		System.out.println();
		System.out.println("levelorder test");
		tree.levelOrder(t0);
		System.out.println();

	}

	public TreeNode buildTreeNodePreInOrder(int[] preorder, int[] inorder) {
		return buildTreeNodePreInOrder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	public TreeNode buildTreeNodePreInOrder(int[] preorder, int[] inorder, int leftp, int rightp, int left, int right) {
		if(left > right) return null;
		TreeNode root = new TreeNode(preorder[leftp]);
		int p = find(inorder, preorder[leftp]);
		root.left = buildTreeNodePreInOrder(preorder, inorder, leftp + 1, leftp +  p - left, left, p - 1);
		root.right = buildTreeNodePreInOrder(preorder, inorder, leftp +  p - left + 1, rightp, p + 1, right);
		return root;
	}

	public int find(int[] a, int target) {
		for(int i = 0; i < a.length; i++) 
			if(target == a[i]) return i;
		return -1;
	}
	public TreeNode buildTreeNodePostInOrder(int[] inorder, int[] postorder) {
		return buildTreeNodePostInOrder(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
	}
	public TreeNode buildTreeNodePostInOrder(int[] inorder, int[] postorder, int leftp, int rightp, int left, int right) {
		if(left > right) return null;
		TreeNode root = new TreeNode(postorder[rightp]);
		int p = find(inorder, postorder[rightp]);
		root.left = buildTreeNodePostInOrder(inorder, postorder, leftp, leftp + p - left - 1, left, p - 1);
		root.right = buildTreeNodePostInOrder(inorder, postorder, leftp + p - left, rightp - 1, p + 1, right);
		return root;
	}
	

	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val);
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
	}

	public void preOrderByStack(TreeNode root) {
//		if (root == null)
//			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				System.out.print(root.val);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
	}

	public void postOrderByStack(TreeNode root) {
//		if (root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		do {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			pre = null;
			while (!stack.isEmpty()) {
				root = stack.pop();
				if (root.right == pre) {
					System.out.print(root.val);
					pre = root;
				} else {
					stack.push(root);
					root = root.right;
					break;
				}
			}
		} while (!stack.isEmpty());
	}

	public void inOrderByStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
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
		return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
	}

	public boolean isBalanced(TreeNode root) {
		return balanceHigh(root) >= 0;
	}
	
	public int balanceHigh(TreeNode root) {
		if(root == null) return 0;
		int left = balanceHigh(root.left);
		int right = balanceHigh(root.right);
		if(Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
		return Math.max(left, right) + 1;
	}

	public List<TreeNode> generateTreeNode(int n) {
		return null;
	}

}
