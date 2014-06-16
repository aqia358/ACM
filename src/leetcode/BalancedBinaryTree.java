package leetcode;

/**
 * Given a binary tree, determine if it is height-balanced. For this problem, a
 * height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 * 
 * @author aqia358
 * 
 */
public class BalancedBinaryTree {

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		if (Math.abs(leftDepth - rightDepth) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	public static int depth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(depth(root.left), depth(root.right));
	}

	public static void main(String[] args) {

	}

}
