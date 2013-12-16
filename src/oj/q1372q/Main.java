package oj.q1372q;

import java.util.Stack;

/**
 * 最大子向量和（连续子数组的最大和）
 * 
 * @author aqia358
 * 
 */
public class Main {

	public void sum(int[] a) {
		int begin = 0;
		int end = 0;
		int max = a[0];
		int tbegin = 0;
		int tend = 0;
		int tsum = a[0];
		for (int i = 1; i < a.length; i++) {
			tsum += a[i];
			tend = i;
			if (tsum > a[i] && tsum > max) {
				max = tsum;
				begin = tbegin;
				end = tend;
			} else if (tsum < a[i] && a[i] > max) {
				max = a[i];
				begin = i;
				end = i;

				tsum = a[i];
				tbegin = i;
				tend = i;
			} else if (tsum < 0) {
				tbegin = i + 1;
				tend = i + 1;
				tsum = 0;
			}
		}
		System.out.println(max + " " + begin + " " + end);
	}

	public static void main(String[] args) {
		Main m = new Main();
		int[] a = { -1, -3, -2 };
		int[] b = { -8, 3, 2, 0, 5 };
		int[] c = { 6, -3, -2 };
		m.sum(a);
		m.sum(b);
		m.sum(c);
	}

}
