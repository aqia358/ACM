package leetcode;

public class BuildBTree {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, postorder, 0, postorder.length - 1, 0, postorder.length - 1);
	}
	
	public static TreeNode build(int[] inorder, int[] postorder,int sin, int ein, int spo, int epo){
		if(sin > ein) return null;
		if(spo > epo) return null;
		TreeNode root = new TreeNode(postorder[ein]);
		int p = getLen(inorder, postorder[ein]);
		int leftlen = p - spo;
		root.left = build(inorder, postorder, sin, sin + leftlen - 1, spo, spo + leftlen - 1);
		root.right = build(inorder, postorder, sin + leftlen, ein - 1, p + 1, epo);
		return root;
	}
	
	public static int getLen(int[] a, int target){
		int p = 0;
		while(a[p] != target)
			p++;
		return p;
	}
	public static void main(String[] args) {
		int[] inorder = {1,3,2};
		int[] postorder = {3,2,1};
		TreeNode root = buildTree(inorder, postorder);
		System.out.println();
	}

}
