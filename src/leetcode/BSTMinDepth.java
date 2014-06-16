package leetcode;

public class BSTMinDepth {

	public int minDepth(TreeNode root){
		if(root == null) return 0;
		return dfs(root, 1);
	}
	
	public static int dfs(TreeNode root, int depth){
		if(root == null) return 9999;
		if(root.left == null && root.right == null)
			return depth;
		return Math.min(dfs(root.left, depth + 1 ), dfs(root.right, depth + 1));
	}
	
	public static void main(String[] args) {

	}

}
