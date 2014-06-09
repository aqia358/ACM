package leetcode;

public class DepthOfTree {

	private static int max = 0;
	
	public static int maxDepth(TreeNode root){
		preOrder(root, 1);
		return max;
	}
	
	public static void preOrder(TreeNode root, int depth){
		if(root == null)return;
		preOrder(root.left, depth + 1);
		if(max < depth) max = depth;
		preOrder(root.right, depth + 1);
	}
	
	public static void main(String[] args) {
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t0.left = t1;
		t1.left = t2;
		t2.left = t3;
		t3.left = t4;
		t4.right = t5;
		t4.left = t6;
		System.out.println(maxDepth(t0));
	}

}

class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x){
		val = x;
	}
}
