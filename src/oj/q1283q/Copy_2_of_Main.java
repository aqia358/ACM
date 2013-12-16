package oj.q1283q;

import java.util.Scanner;

public class Copy_2_of_Main {

	public static void findOne(String s) {
		int[]a = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int b = s.charAt(i);
			if(a[b] == 1)
				a[b] = 2;
			else
				a[b] = 1;
		}
		for(int j = 0; j < s.length(); j++){
			if(a[s.charAt(j)] == 1){
				System.out.println(j);
				return;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
//		findOne("AA");
//		findOne("ABACCDEFF");
		Scanner s = new Scanner(System.in);
		while (true) {
			String str = s.next();
			findOne(str);
		}
	}
}
