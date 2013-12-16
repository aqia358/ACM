package oj.q1283q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyOfMain {

	public static void findOne(String s){
		for(int i = 0; i < s.length(); i++){
			boolean flag = false;
			for(int j = 0; j < s.length(); j++){
				if(s.charAt(i) == s.charAt(j) && i != j)
					flag = true;
			}
			if(!flag){
				System.out.println(1);
				return;
			}
		}
		System.out.println(-1);
			
	}
	public static void main(String[] args) {
//		findOne("ABA");
//		findOne("AA");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while(true){
			try {
				String s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
