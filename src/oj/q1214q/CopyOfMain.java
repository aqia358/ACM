package oj.q1214q;

import java.util.Scanner;

public class CopyOfMain {

	public boolean isPrime(int number){
		boolean flag = true;
		for(int i = 2; i <= Math.sqrt(number); i++){
			if(number % i == 0){
				flag = false;
				break;
			}
		}
		return flag;
	}
	public boolean isUgly(int number){
		if(isPrime(number)){
			if(number == 2 || number == 3 || number == 5 || number == 1)
				return true;			
			else{
				return false;
			}
		}
		boolean flag = false;
		for(int i = 2; i < Math.sqrt(number) + 1; i++){
			int a = number % i;
			if(a == 0){
				flag = isUgly(i)&&isUgly(number/i);
			}
		}
		return flag;
	}
	public void countUgly(int count){
		if(count <= 6)
			System.out.println(count);
		else{
			int j = 6;
			int number = 7;
			while(j < count){
				if(isUgly(number++)){
					j++;
				}
			}
			System.out.println(number-1);
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CopyOfMain m = new CopyOfMain();
		m.countUgly(s.nextInt());
	}

}
