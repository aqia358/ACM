package oj.q1514q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.NumberFormat;

/**
 * 数值的整数次方 
 * @author aqia358
 * no AC
 */
public class Main {

	public static void POW(double base, int e){
		double b = Math.pow(base, e);
		int f = 0;
		System.out.println(b);
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int) st.nval;
			while(n > 0){
				n -- ;
				st.nextToken();
				double base = (double) st.nval;
				st.nextToken();
				int e = (int) st.nval;
				POW(base,e);
			}
		}
//		POW(1.0,10);
//		POW(0.0,-5);
//		POW(1.0,0);
//		POW(1.2,5);
//		POW(0.03,-1);
	}
}
