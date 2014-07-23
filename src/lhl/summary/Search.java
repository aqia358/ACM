package lhl.summary;

public interface Search {
	
	/**
	 * [5,7,7,8,8,10] 8 => 3,4
	 */
	public abstract void searchForRange(int[] a, int target);
	
	public abstract void searchInsertPosition(int[] a, int target);
	
	public abstract void search2DMatrix(int[][] a, int target);
}
