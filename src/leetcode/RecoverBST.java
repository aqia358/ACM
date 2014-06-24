package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecoverBST {

	public static void recoverTree(TreeNode root){
		List<TreeNode> list = new ArrayList<TreeNode>();
		inOrder(root, list);
		int s = 0;
		int e = list.size() - 1;
		while(s <= e - 1 && list.get(s).val < list.get(s + 1).val)
			s++;
		while(e >= s + 1 && list.get(e).val > list.get(e - 1).val)
			e--;
		int temp = list.get(s).val;
		list.get(s).val = list.get(e).val;
		list.get(e).val	= temp;
	}
	
	public static void inOrder(TreeNode root,List<TreeNode> l){
		if(root == null) return;
		inOrder(root.left, l);
		l.add(root);
		inOrder(root.right, l);
	}
	public static TreeNode vaildTree(TreeNode root, int min, int max){
		if(root == null) return null;
		if(root.val > min && root.val < max){
			return vaildTree(root.left, min, root.val) == null ? null : 
				vaildTree(root.right, root.val, max);
		}else{
			return root;
		}
			
	}
	public static void main(String[] args) {
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		t0.left = t1;
		recoverTree(t0);
	}

}
