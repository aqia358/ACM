package leetcode;

public class UniquePaths2 {

	public static int sum = 0;
	public static int uniquePath(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		if(m == 0) return 0;
		int n = obstacleGrid[0].length;
		int index = 0;
		while(index < n && obstacleGrid[0][index] != 1)
			obstacleGrid[0][index++] = 1;
		while(index < n)
			obstacleGrid[0][index++] = 0;
		for(int i = 1; i < m; i++){
			for(int j = 0; j < n; j++){
				if(obstacleGrid[i][j] == 1)
					obstacleGrid[i][j] = 0;
				else{
					if(j == 0)
						obstacleGrid[i][j] = obstacleGrid[i - 1][j];
					else
						obstacleGrid[i][j] = obstacleGrid[i -1][j] + obstacleGrid[i][j - 1];
				}
			}
		}
		return obstacleGrid[m - 1][n - 1];
	}
	public static int uniquePath2(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		if(m == 0) return 0;
		int n = obstacleGrid[0].length;
		uniquepath(0, 0, m - 1, n - 1, obstacleGrid);
		return sum;
	}
	public static int testuniquepath2(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		if(m == 0) return 0;
		int n = obstacleGrid[0].length;
		return uniquepath2(m , n , obstacleGrid);
	}
	public static int uniquepath2(int m, int n, int[][] a){
		if(m == 1 && n == 1)
			return 1;
		if(m < 1 || n < 1 || a[m - 1][n - 1] == 1)
			return 0;
		return uniquepath2( m - 1, n, a) + uniquepath2(m, n - 1, a);
	}
	public static void uniquepath(int x, int y, int m, int n, int[][] a){
		if(x == m && y == n)
			sum++;
		
		if(x < m && y < n && a[x][y] == 1)
			return;
		if(x < m){
			uniquepath(x + 1, y, m, n, a);
		}
		if(y < n){
			uniquepath(x, y + 1, m, n, a);
		}
	}
	public static void main(String[] args) {
		int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(testuniquepath2(a));
		System.out.println(uniquePath(a));
	}

}
