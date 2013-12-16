package oj.q1386q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 旋转数组的最小数字
 * @author aqia358
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != st.TT_EOF) {
			int n = (int) st.nval;
			int count = 0;
			int[] a = new int[n];
			boolean flag = false;
				while (count < n) {
					st.nextToken();
					a[count] = (int) st.nval;
					if (count >= 1) {
						if (a[count] < a[count - 1]) {
							flag = true;
							System.out.println(a[count]);
						}
					}
					count++;
				}
				if(!flag)
					System.out.println(a[0]);
		}
	}

}
