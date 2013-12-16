package oj.q1389q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 斐波那契数列之变态青蛙跳台阶
 * @author aqia358
 *
 */
public class Main {

	public static long f(int n){
		long[] a = new long[n+2];
		a[1] = 1;
		a[2] = 2;
		int pos = 3;
		while(pos <= n){
			a[pos] = a[pos-1] * 2;
			pos++;
		}
		return a[n];
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			System.out.println(f((int)st.nval));
		}
	}

}
