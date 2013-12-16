package oj.q1513q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 二进制中1的个数 
 * @author aqia358
 *
 */
public class Main {

	public static void count(int t) {
		if (t >> 31 == 0) {
			System.out.println(num(t));
		}else{
			long a = 1;
			int b = (int)(a << 32) + t;
			System.out.println(num(b));
		}
	}

	public static int num(int t) {
		int count = 0;
		int n = 0;
		while (n < 32) {
			n++;
			if ((t & 1) != 0) {
				count++;
			}
			t >>= 1;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int) st.nval;
			while(n > 0){
				n -- ;
				st.nextToken();
				count((int) st.nval);
			}
		}
	}
}
