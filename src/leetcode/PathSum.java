package leetcode;

import java.util.Stack;

public class PathSum {

	public static boolean hasPathSum(TreeNode root, int sum){
		if(root == null) return false;
		if(root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	public static boolean postOrder(TreeNode root, int sum, int temp){
		if(root == null){
			return true;
		}
		temp += root.val;
		boolean flag = postOrder(root.left, sum, temp);
		boolean flag2 = postOrder(root.right, sum, temp);
		if(flag && flag2 && temp == sum)
			return false;
		return  true ;
	}
	public static boolean inOrder(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		if(root == null) return false;
		while(!s.isEmpty() || root != null){
			while(root != null){
				s.add(root);
				root = root.left;
			}
			root = s.pop();
			System.out.print(root.val);
			root = root.right;
		}
		return false;
	}
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t8 = new TreeNode(8);
		TreeNode t11 = new TreeNode(11);
		TreeNode t13 = new TreeNode(13);
		TreeNode t41 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		t5.left = t4;
		t5.right = t8;
		t4.left = t11;
		t11.left = t7;
		t11.right = t2;
		t8.left = t13;
		t8.right = t41;
		t41.right = t1;
		inOrder(t5);
		System.out.println(hasPathSum(t5, 22));
	}

}
