package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * @author aqia358
 *
 */
public class GrayCode {

	public static int num = 0;
	public static List<Integer> grayCode(int n){
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		getCode(list, n - 1);
		return list;
	}
	
	public static void getCode(List<Integer> list, int n){
		if(n < 0)return;
		getCode(list, n - 1);
		num ^= 1 << n;
		list.add(num);
		getCode(list, n - 1);
	}
	
	public static void main(String[] args) {
		for(Integer a : grayCode(3)){
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
