package oj.q1283q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 第一个只出现一次的字符
 * @author aqia358
 *
 */
public class Main {

	public static void findOne(String s) {
		int[] a = new int[26];
		int lenght = s.length();
		for (int i = 0; i < lenght; i++) {
			a[s.charAt(i) - 'A']++;
		}
		for (int j = 0; j < lenght; j++) {
			if (a[s.charAt(j) - 'A'] == 1) {
				System.out.println(j);
				return;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
//		 findOne("AA");
//		 findOne("ABACCDEFF");
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (st.nextToken() != st.TT_EOF) {
			String str = st.sval;
			findOne(str);
		}
	}
}
