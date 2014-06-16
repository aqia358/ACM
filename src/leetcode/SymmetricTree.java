package leetcode;

public class SymmetricTree {

	public static boolean isSysmmetric(TreeNode root){
		if(root == null) return true;
		return inorder(root.left, root.right);
	}
	
	public static boolean inorder(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null)return true;
		if(t1 == null && t2 != null)return false;
		if(t2 == null && t1 != null)return false;
		boolean f1 = inorder(t1.left, t2.right);
		boolean f2 = inorder(t1.right, t2.left);
		if(t1.val == t2.val)
			return f1 && f2;
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		System.out.println(isSysmmetric(t1));
		t4.left = t6;
		System.out.println(isSysmmetric(t1));
	}

}
