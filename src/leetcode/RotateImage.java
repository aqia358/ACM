package leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * @author aqia358
 *
 */
public class RotateImage {

	public static void rotate(int[][] matrix){
		int len = matrix.length;
		int[][] t = new int[len][len];
		for(int row = 0; row < len; ++row){
			for(int col = 0; col < len; ++col){
				t[col][len - 1 - row] = matrix[row][col];
			}
		}
		System.arraycopy(t, 0, matrix, 0, len);
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2},{3,4}};
		rotate(a);
	}

}
