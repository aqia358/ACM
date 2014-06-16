package leetcode;

public class GenerateMatrix {

	public static int[][] generateMatrix(int n){
		int[][] result = new int[n][n];
		int c = 1;
		int left,right,top,bottom;
		left = top = 0;
		right = bottom = n - 1;
		while(c <= Math.pow(n, 2)){
			for(int i = left; i <= right; ++i){
				result[top][i] = c++;
			}
			top++;
			for(int i = top; i <= bottom; ++i){
				result[i][right] = c++;
			}
			right--;
			for(int i = right; i >= left; --i){
				result[bottom][i] = c++;
			}
			bottom--;
			for(int i = bottom; i >= top; --i){
				result[i][left] = c++;
			}
			left++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		generateMatrix(4);
	}

}
