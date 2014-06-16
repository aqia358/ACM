package leetcode;

public class UniquePaths {

	public static int uniquePaths(int m, int n){
		if(m <=0 || n <= 0) return 0;
 		if(m == 1 && n == 1) return 1;
		int sum = 0;
		if(m > 1)
			sum += uniquePaths(m - 1, n);
		if(n > 1)
			sum += uniquePaths(m, n - 1);
		return sum;
	}
	
	public static int Binomial(int m, int n){
		m = m + n - 2;
		n = n - 1;
		int[] f = new int[n + 1];
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(j == 0 || i == j){
					f[j] = 1;
				}else
					f[j] = f[j - 1] + f[j];
			}
		}
		return f[n];
	}
	
	public static int Binomial2(int m, int n){
		m = m + n - 2;
		n = n - 1;
		int[][] c = new int[m + 1][n + 1];
		for(int i = 0; i <= m; ++i){
			for(int j = 0; j <= Math.min(i, n); ++j){
				if(j == 0 || i == j){
					c[i][j] = 1;
				}else{
					c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
				}
			}
		}
		return c[m][n];
	}
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 2)); 
		System.out.println(Binomial(2, 2)); 
		System.out.println(Binomial2(2, 2)); 
		System.out.println(uniquePaths(2, 3)); 
		System.out.println(uniquePaths(3, 3));
		System.out.println(uniquePaths(3, 4));
		System.out.println(uniquePaths(4, 4));
		System.out.println(uniquePaths(4, 1));
		System.out.println(uniquePaths(4, 5));
	}

}
