package oj.q1348q;

import java.util.Scanner;

/**
 * 数组中的逆序对
 * 2014年3月15日 20:44:15
 * @author aqia358
 * 
 */
public class MainLM {

	public static void count(int[] a){
		long sum = 0;
		for(int i = 1; i < a.length; i++){
			int j = i;
			while(j > 0){
				if(a[j - 1] > a[i])
					sum++;
				j--;
			}
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
//		int[] a = {7,5,6,4};
//		int[] a = {9,8,7,6,5,4,3,2,1,0};
//		MainLM.count(a);
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = cin.nextInt();
			}
			MainLM.count(a);
		}
	}
}
