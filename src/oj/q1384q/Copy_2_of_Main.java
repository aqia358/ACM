package oj.q1384q;

import java.util.Scanner;

public class Copy_2_of_Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int row = s.nextInt();
			int col = s.nextInt();
			int target = s.nextInt();
			int posR = 0;
			int posC = col - 1;
			int[][] array = new int[row][col];
			boolean flag = false;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					array[i][j] = s.nextInt();
				}
			}
			while (array[posR][posC] < target && posR < row) {
				posR++;
			}
			while (array[posR][posC] > target && posC > 0) {
				posC--;
			}
			for (int n = posR; n < row; n++){
				for (int m = 0; m <= posC; m++)
					if (array[n][m] == target)
						flag = true;
			}
			if (flag)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
