package lhl.summary;

import java.util.List;

/**
 * 深度遍历（preOrder,inOrder,postOrder)递归非递归 广度遍历 树的最大最小深度，路径 是否是平衡二叉树 生成1-n所有二叉树
 */
public interface Tree {

	public TreeNode buildTreeNodePreInOrder(int[] preorder, int[] inorder);

	public TreeNode buildTreeNodePostInOrder(int[] inorder, int[] postorder);

	public void preOrder(TreeNode root);

	public void postOrder(TreeNode root);

	public void inOrder(TreeNode root);

	public void preOrderByStack(TreeNode root);

	public void postOrderByStack(TreeNode root);

	public void inOrderByStack(TreeNode root);

	public void levelOrder(TreeNode root);

	public int minDepth(TreeNode root, int depth);

	public int maxDepth(TreeNode root, int depth);

	public boolean isBalanced(TreeNode root);

	public List<TreeNode> generateTreeNode(int n);

}
