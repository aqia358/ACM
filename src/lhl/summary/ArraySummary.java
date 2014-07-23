package lhl.summary;

/**
 * 二分查找
 * nSum a+b+c=0?
 * 左一遍右一遍
 * 左右向中间夹
 * 全排列Next Permutation
 * @author aqia358
 *
 */
public interface ArraySummary {
	
	/**
	 * duplicates are allowed
	 */
	public void SearchInRotatedSortedArray2(int[] a);

	public void NextPermutation(int[] a);
	
	public void rotate(int[][] matrix);
	
	public void plusOne(int[] a);
	
	/**
	 * f(n) = f(n-1) + f(n-2);
	 * 非递归
	 * @param n
	 */
	public void climbStairs(int n);
	
	public void candy(int[] a);
	
}
