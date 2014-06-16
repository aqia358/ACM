package leetcode;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author aqia358
 *
 */
public class NQueens {

	public static int count;
	public static int totalNQueens(int n){
		int[] q = new int[n];
		placeQueen(q, 0);
		return count;
	}
	
	public static void placeQueen(int[] q, int row){
		if(row == q.length){
			count++;
			return;
		}
		for(int i = 0; i < q.length; i++){
			if(isSafe(q, row, i)){
				q[row] = i;
				placeQueen(q, row + 1);
			}
		}
	}
	
	public static boolean isSafe(int[] q, int row, int col){
		int left = row - col;
		int right = row + col;
		for(int i = 0; i< row; ++i){
			if(i - q[i] == left)
				return false;
			if(i + q[i] == right)
				return false;
			if(i == row)
				return false;
			if(q[i] == col)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(totalNQueens(2));
	}

}
