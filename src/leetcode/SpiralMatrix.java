package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> re = new ArrayList<Integer>();
		int top = 0;
		int bottom = matrix.length - 1;
		if(bottom == -1) return re;
		int left = 0;
		int right = matrix[0].length - 1;
		while(left <= right && top <= bottom){
			for(int i = left; i <= right; i++)
				re.add(matrix[top][i]);
			if(++top > bottom) break;
			for(int j = top; j <= bottom; j++)
				re.add(matrix[j][right]);
			if(left > --right) break;
			for(int m = right; m >= left; m--)
				re.add(matrix[bottom][m]);
			if(top > --bottom) break;
			for(int n = bottom; n >= top; n--)
				re.add(matrix[n][left]);
			if(++left > right) break;
		}
		return re;
	}
	public static List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> re = new ArrayList<Integer>();
		int top = 0;
		int bottom = matrix.length - 1;
		if(bottom == -1) return re;
		int left = 0;
		int right = matrix[0].length - 1;
		while(left <= right && top <= bottom){
			for(int i = left; i <= right && top <= bottom; i++)
				re.add(matrix[top][i]);
			if(top <= bottom) top++;
			for(int j = top; j <= bottom && left <= right; j++)
				re.add(matrix[j][right]);
			if(left <= right) right--;
			for(int m = right; m >= left && top <= bottom; m--)
				re.add(matrix[bottom][m]);
			if(top <= bottom) bottom--;
			for(int n = bottom; n >= top && left <= right; n--)
				re.add(matrix[n][left]);
			if(left <= right) left++;
		}
		return re;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1}, {2}, {3}};
//		int[][] a = {{1, 2, 3}};
//		int[][] a = {{1, 2, 3},{4, 5, 6}};
//		int[][] a = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		List<Integer> l = spiralOrder(a);
		for(Integer t : l)
			System.out.print(t);
	}

}
