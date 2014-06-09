package practice.day1.dynamicprogram.floyd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//3
//1.2 .89
//.88 5.1
//1.1 0.15
//4
//3.1    0.0023    0.35
//0.21   0.00353   8.13 
//200    180.559   10.339
//2.11   0.089     0.06111
//2
//2.0
//0.45

public class Arbitrage {

	public static int n;
	public static float[][][] f;
	public static int[][][] path;

	public static void floyd() {
		int p, i, j, k;
		p = i = j = k = 0;
		for (p = 1; p < n; p++) {
			for (i = 0; i < n; ++i)
				for (j = 0; j < n; ++j)
					for (k = 0; k < n; ++k) {//找到f(p-1)到f(p)转换的最大值保存下来，同时保存转换路径
						if (f[p - 1][i][k] * f[0][k][j] > f[p][i][j]) {
							f[p][i][j] = f[p - 1][i][k] * f[0][k][j];
							path[p][i][j] = k;
						}
					}
			for (int m = 0; m < n; ++m) {
				if (f[p][m][m] > 1) {
					// System.out.println("find some thing");
					print(m, m, p);
					System.out.println();
				}
			}
		}
	}

	public static void print(int i, int j, int p) {
		if (p == 0) {
			System.out.print(i+" ");//打印起点
			System.out.print(j+" ");//打印起点后打印途径点
		} else {
			print(i, path[p][i][j], p - 1);//先遍历到起点再开始打印
			System.out.print(j+" ");//打印途径点
		}
	}

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(new File("D:/a.txt"));
			StreamTokenizer st = new StreamTokenizer(new BufferedReader(
					new InputStreamReader(fis)));
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				System.out.println("-------");
				n = (int) st.nval;
				f = new float[n][n][n];
				path = new int[n][n][n];
				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < n; ++j) {
						if (i == j)
							f[0][i][j] = 1;
						else {
							st.nextToken();
							f[0][i][j] = (float) st.nval;
						}
					}
				}
				floyd();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
