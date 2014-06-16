package leetcode;

/**
 * m*n矩阵从左上角到右下角最短距离
 * @author aqia358
 *
 */
public class MinPathSum {

	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		if(row == 0 || col == 0) return 0;
		for(int i = 0; i < row; ++i){
			for(int j = 0; j < col; ++j){
				int min = grid[i][j];
				if(i - 1 >= 0 && j - 1 < 0)
					grid[i][j] = grid[i-1][j] + min;
				if(j - 1 >= 0 && i - 1 < 0)
					grid[i][j] = grid[i][j - 1] + min;
				if(i - 1 >= 0 && j - 1 >= 0)
					grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + min;
			}
		}
		return grid[row - 1][col - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.print(minPathSum(grid));
	}

}
