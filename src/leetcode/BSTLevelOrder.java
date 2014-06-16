package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BSTLevelOrder {

	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		levelOrder(root, result, 0);
		return result;
	}
	
	public static void levelOrder(TreeNode root, List<List<Integer>> result, int level){
		if(root == null) return;
		List<Integer> l;
		if(result.size() <= level){
			l = new ArrayList<Integer>();
			result.add(l);
		} else
			l = result.get(level);
		l.add(root.val);
		levelOrder(root.left, result, level + 1);
		levelOrder(root.right, result, level + 1);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		levelOrder(t1);
	}

}
