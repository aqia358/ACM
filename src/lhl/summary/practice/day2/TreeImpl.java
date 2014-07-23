package lhl.summary.practice.day2;
import java.util.List;
import java.util.Stack;

import lhl.summary.Tree;
import lhl.summary.TreeNode;
public class TreeImpl implements Tree{

	public static void main(String[] args) {

	}

	public TreeNode buildTreeNodePreInOrder(int[] preorder, int[] inorder) {
		return null;
	}

	public TreeNode buildTreeNodePostInOrder(int[] inorder, int[] postorder) {
		return null;
	}

	public void preOrder(TreeNode root) {
		
	}

	public void postOrder(TreeNode root) {
		
	}

	public void inOrder(TreeNode root) {
		
	}

	public void preOrderByStack(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(!s.isEmpty() || root != null){
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
		Stack<TreeNode> s = new Stack<TreeNode>();
		do {
			while(root != null){
				s.push(root);
				root = root.left;
			}
			TreeNode pre = root;
			
			
		} while(!s.isEmpty());
	}

	public void inOrderByStack(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(!s.isEmpty() || root != null){
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
		// TODO Auto-generated method stub
		
	}

	public int minDepth(TreeNode root, int depth) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int maxDepth(TreeNode root, int depth) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBalanced(TreeNode root) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<TreeNode> generateTreeNode(int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
