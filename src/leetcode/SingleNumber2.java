package leetcode;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * @author aqia358
 *
 */
public class SingleNumber2 {

	public static int singleNumber(int[] A){
		int len = A.length;
		int one,two,three;
		one = two = three = 0;
		for(int i = 0; i < len; i++){
			two |= one&A[i];
			one ^= A[i];
			three = one & two;
			one &= ~three;
			two &= ~three;
		}
		return one;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,1,2};
		int[] b = {1};
		System.out.println(singleNumber(a));
		System.out.println(singleNumber(b));
	}

}
