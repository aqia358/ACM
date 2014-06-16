package leetcode;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class SetMatrixZeroes {

	public static void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		Map<Integer, Integer> visRow = new HashMap<Integer, Integer>();
		Map<Integer, Integer> visCol = new HashMap<Integer, Integer>();
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (matrix[i][j] == 0) {
					visRow.put(i, 1);
					visCol.put(j, 1);
				}
			}
		}
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if(visRow.get(i) != null)
					matrix[i][j] = 0;
				else{
					if(visCol.get(j) != null)
						matrix[i][j] = 0;
				}
			}
		}
	}

	public static void setZeroes2(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[] visRow = new int[row];
		int[] visCol = new int[col];
		for (int i = 0; i < row; ++i) {
			if (visRow[i] == 0) {
				for (int j = 0; j < col; ++j) {
					if (visCol[j] == 0 && matrix[i][j] == 0) {
						visRow[i] = 1;
						visCol[j] = 1;
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			if (visRow[i] != 0) {
				for (int j = 0; j < col; j++)
					matrix[i][j] = 0;
			}
		}
		for (int i = 0; i < col; i++) {
			if (visCol[i] != 0) {
				for (int j = 0; j < row; j++)
					matrix[j][i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// int[][] a = {{1,2,3},{1,0,3},{4,5,6}};
		int[][] a = { { 0 }, { 1 } };
		setZeroes(a);
		System.out.println();
	}

}
