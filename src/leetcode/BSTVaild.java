package leetcode;

public class BSTVaild {

	public static boolean isValidBST(TreeNode root){
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isValidBST(TreeNode root, int min, int max) {
		if(root == null) return true;
		return root.val > min && root.val < max && isValidBST(root.left, min, root.val) && 
				isValidBST(root.right, root.val, max);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
//		t1.left = t2;
//		t1.right = t3;
//		t3.left = t2;
//		t3.right = t5;
//		t2.left = t1;
//		t5.left = t4;
//		t5.right = t6;
		t3.left = t1;
//		t3.right = t1;
		System.out.println(isValidBST(t3));
	}

}
