package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InOrderBT {

	public static List<Integer> list = new ArrayList<Integer>();
	public static void inOrder(TreeNode root){
		if(root == null)return;
		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		root.right = root2;
		inOrder(root);
		System.out.println(list.size());
	}

}
