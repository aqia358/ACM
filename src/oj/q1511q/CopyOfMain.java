package oj.q1511q;

import java.util.Scanner;

public class CopyOfMain {

	Scanner s = new Scanner(System.in);
	public void add(){
		int value = 0;
		if((value = s.nextInt()) != -1){
			add();
		}
		if(value != -1)
			System.out.println(value);
	}
	public static void main(String[] args) {
		CopyOfMain m = new CopyOfMain();
		m.add();
	}

}
