package leetcode;

public class SumRootToLeaf {

	public static int ssum = 0;
	public static int sumNumbers(TreeNode root){
		return dfs(root, 0);
	}
	public static int dfs(TreeNode root, int sum){
		if(root == null) return 0;
		if(root.left == null && root.right == null)
			return sum * 10 + root.val;
		return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
	}
	public static int sumNumbers2(TreeNode root){
		if(root == null) return 0;
		preOrder(root, 0);
		return ssum;
	}
	
	public static void preOrder(TreeNode root, int sum){
		if(root == null) return ;
		preOrder(root.left, sum*10 + root.val);
		preOrder(root.right, sum*10 + root.val);
		if(root.left == null &&  root.right == null)
			ssum += sum * 10 + root.val;
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		System.out.println(sumNumbers(t1));
	}

}
