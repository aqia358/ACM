package leetcode;

public class SameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		return preOrder(p, q);
	}

	public static boolean preOrder(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if((p == null && q != null) || (q == null && p != null))
			return false;
		if (p.val != q.val)
			return false;
		else
			return preOrder(p.left, q.left) && preOrder(p.right, q.right);
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
		
		System.out.println(isSameTree(t0, t0));
		System.out.println(isSameTree(t0, t1));
	}

}
