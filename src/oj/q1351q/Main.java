package oj.q1351q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 数组中只出现一次的数字
 * @author aqia358
 *
 */
public class Main {

	public static void find(int[] a,int result) {
		int pos = 1;
		while ((result & pos) == 0) {
			pos <<= 1;
		}
		int num1 = 0;
		int num2 = 0;
		for (int j = 0; j < a.length; j++) {
			if ((a[j] & pos) == 0)
				num1 ^= a[j];
			else
				num2 ^= a[j];
		}
		if (num1 < num2)
			System.out.println(num1 + " " + num2);
		else
			System.out.println(num2 + " " + num1);
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (st.nextToken() != st.TT_EOF) {
			int length = (int) st.nval;
			int[] array = new int[length];
			int count = 0;
			int result = 0;
			while (count < length) {
				st.nextToken();
				array[count] = (int)st.nval;
				result ^= array[count++];
			}
			find(array,result);
		}
	}

}
