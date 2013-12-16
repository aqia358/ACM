package page1.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] p = s.split(" ");
		BigInteger aa = new BigInteger(p[0]);
		BigInteger bb = new BigInteger(p[1]);
		System.out.println(aa.add(bb.multiply(new BigInteger("-1"))));

	}
}
