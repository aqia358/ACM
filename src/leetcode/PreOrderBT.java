package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderBT {

	public static List<Integer> list = new ArrayList<Integer>();
	public static void preOrder(TreeNode root){
		if(root == null)return;
		list.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {

	}

}
