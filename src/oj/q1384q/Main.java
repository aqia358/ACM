package oj.q1384q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 查找二维数组中是否出现某个数
 * @param args
 */
public class Main {

	public static void main(String[] args) {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		try {
			while (st.nextToken() != st.TT_EOF) {
				int row = (int) st.nval;
				st.nextToken();
				int col = (int) st.nval;
				st.nextToken();
				int target = (int) st.nval;
//				int[][] array = new int[row][col];
				boolean flag = false;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						st.nextToken();
						int a = (int) st.nval;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
