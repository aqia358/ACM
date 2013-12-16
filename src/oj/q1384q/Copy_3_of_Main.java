package oj.q1384q;

import java.util.Scanner;
/**
 * use scanner 方法
 * @author aqia358
 *
 */
public class Copy_3_of_Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {

			int row = s.nextInt();
			int col = s.nextInt();
			int target = s.nextInt();
			int[][] array = new int[row][col];
			boolean flag = false;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					int a = s.nextInt();
					if (target == a) {
						flag = true;
					}
				}
			}

			if (flag) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
