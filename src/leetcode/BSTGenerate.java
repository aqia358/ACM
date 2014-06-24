package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BSTGenerate {

	public static List<TreeNode> generateTrees(int n) {
		return buildtree(1, n);
	}
	
	public static List<TreeNode> buildtree(int s, int e){
		List<TreeNode> l = new ArrayList<TreeNode>();
		if(s > e){
			l.add(null);
			return l;
		}
		for(int m = s; m <= e; m++){
			List<TreeNode> left = buildtree(s, m - 1);
			List<TreeNode> right = buildtree(m + 1, e);
			for(TreeNode i : left){
				for(TreeNode j : right){
					TreeNode t = new TreeNode(m);
					t.left = i;
					t.right = j;
					l.add(t);
				}
			}
		}
		return l;
	}

	public static void main(String[] args) {
		List<TreeNode> l = generateTrees(3);
		System.out.println();
	}

}
