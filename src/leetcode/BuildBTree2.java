package leetcode;

public class BuildBTree2 {

	public static TreeNode buildTree(int[] preorder, int[] inorder){
		return build(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
	}
	
	public static TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie ){
		if(ps > pe) return null;
		if(is > ie) return null;
		TreeNode root = new TreeNode(preorder[ps]);
		int p = getPos(inorder, preorder[ps]);
		int len = p - is;
		root.left = build(preorder, inorder, ps + 1, ps + len, is, is + len - 1);
		root.right = build(preorder, inorder, ps + len + 1, pe, is + len + 1, ie);
		return root;
	}
	
	public static int getPos(int[] a, int target){
		int p = 0;
		while(a[p] != target)
			p++;
		return p;
	}
	
	public static void main(String[] args) {
		int[] p = {1,2,4,5,3};
		int[] in = {4,2,5,1,3};
		TreeNode t = buildTree(p, in);
		System.out.println();
	}

}
