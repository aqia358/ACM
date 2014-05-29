package practice.day1.dynamicprogram;

/**
 * 国际象棋中的车可以水平的或竖直的移动，一个车要从一个棋盘的一角移到对角线的另一角，有多少种最短路径？
 * @author aqia358
 *
 */
public class Main {
	public static int[][] result;
	public static void dp(int n, int k){
		result = new int[n + 1][k + 1];
		for(int i = 0; i <= n; ++i){
			for(int j = 0; j <= n; ++j){
				if(j == 0)
					result[i][0] = 1;
				else if(i == 0)
					result[0][j] = 1;
				else
					result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
	}

	public static int min(int a, int b){
		if(a > b)return b;
		else return a;
	}
	
	public static void main(String[] args) {
		dp(4, 4);
		for(int i = 0; i < result.length; ++i){
			for(int j = 0; j < result.length; ++j){
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
