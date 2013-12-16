package oj.q1362q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 左旋转字符串
 * 19时38分24秒
 * @author aqia358
 * 19时47分16秒
 *
 */
public class Main {

	public void move(String s, int n){
		int len = s.length();
		String part1 = s.substring(0, n%len);
		String part2 = s.substring(n%len, len);
		System.out.println(part2+part1);
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			String str = st.sval;
			st.nextToken();
			int n = (int)st.nval;
			m.move(str, n);
		}
	}

}
