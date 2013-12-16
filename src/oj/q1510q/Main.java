package oj.q1510q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串替换
 * @author aqia358
 *
 */
public class Main {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String s = br.readLine();
			String ns = s.replace(" ", "%20");
			System.out.println(ns);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
