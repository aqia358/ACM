package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		path(root, 0, sum, new ArrayList<Integer>(), lists);
		return lists;
	}
	
	public static void path(TreeNode root, int tempSum, int sum, ArrayList<Integer> l, List<List<Integer>> lists){
		if(root == null)
			return;
		ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
		c.add(root.val);
		tempSum += root.val;
		path(root.left, tempSum, sum, c, lists);
		path(root.right, tempSum, sum, c, lists);
		if(root.left == null && root.right == null && tempSum == sum)
			lists.add(c);
	}
	
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t8 = new TreeNode(8);
		TreeNode t11 = new TreeNode(11);
		TreeNode t13 = new TreeNode(13);
		TreeNode t44 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode t55 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		t5.left = t4;
		t5.right = t8;
		t4.left = t11;
		t11.left = t7;
		t11.right = t2;
		t8.left = t13;
		t8.right = t44;
		t44.left = t55;
		t44.right = t1;
		TreeNode a = new TreeNode(-2);
		TreeNode a1 = new TreeNode(-3);
		a.left = a1;
//		pathSum(t5, 22);
		pathSum(a, -5);
	}

}
