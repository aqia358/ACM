package leetcode;

import java.util.Stack;

public class MaximalRectangle {

	public static int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		if(row == 0) return 0;
		int col = matrix[0].length;
		int[][] a = new int[row][col + 1];
		for(int i = 0; i < row; i++)
			a[i][col] = 0;
		for(int i = 0; i < col; i ++){
			for(int j = 0; j < row; j++){
				if(j == 0){
					a[j][i] = (matrix[j][i] == '1') ? 1 : 0;
				} else{
					a[j][i] = (matrix[j][i] == '1') ? (a[j - 1][i] + 1) : 0;
				}
			}
		}
		int max = 0;
		for(int r = 0; r < row; r++){
			int p = 0;
			Stack<Integer> s = new Stack<Integer>();
			while(p < col + 1){
				if(s.isEmpty() || a[r][s.peek()] <= a[r][p]){
					s.add(p);
					p++;
				}else{
					int t = s.pop();
					max = Math.max(max, a[r][t] * (s.isEmpty() ? p : (p - s.peek() - 1)));
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		char[][] a = {{'0','1'},{'0','1'}};
//		char[][] a = {
//				{0,0,0,0},
//				{0,0,0,0},
//				{0,0,0,0},
//				{0,0,0,0}};
//		char[][] a = {{'1',0,0,'1'},
//				{'1',0,0,'1'},
//				{'1',0,0,'1'},
//				{0,0,0,0}};
		System.out.println(maximalRectangle(a));
	}

}
