package leetcode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author aqia358
 *
 */
public class ArrayToBST {

	public static TreeNode sortedArrayToBST(int[] num, int begin, int end){
		if(begin > end)
			return null;
		int center = (begin + end)/2;
		TreeNode root = new TreeNode(num[center]);
		root.left = sortedArrayToBST(num, begin, center - 1);
		root.right = sortedArrayToBST(num, center + 1, end);
		return root;
	}
	public static TreeNode sortedArrayToBST(int[] num){
		if(num.length == 0)
			return null;
		int center = num.length/2;
		TreeNode root = new TreeNode(num[center]);
		root.left = sortedArrayToBST(num, 0, center - 1);
		root.right = sortedArrayToBST(num, center + 1, num.length - 1);
		return root;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,7,8};
		int[] a = {};
		TreeNode root = sortedArrayToBST(num);
		TreeNode root2 = sortedArrayToBST(a);
	}

}
