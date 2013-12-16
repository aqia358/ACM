package oj.q1384q;

import java.util.Scanner;

public class CopyOfMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int row = s.nextInt();
			int col = s.nextInt();
			int target = s.nextInt();
			int pos = 0;
			boolean flag = false;
//			System.out.println(row+" "+col+" "+target );
			while(pos < row*col){
				pos++;
				if(target == s.nextInt())
					flag = true;
			}
			if(flag)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
