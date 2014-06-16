package leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author aqia358
 *
 */
public class PlusOne {

	public static int[] plusOne(int[] digits){
		int len = digits.length;
		int c = 1;
		int temp = 0;
		for(int i = len - 1; i >= 0; --i){
			temp = digits[i] + c;
			digits[i] = temp%10;
			c = temp/10;
		}
		if(c == 0)
			return digits;
		else{
			int[] result = new int[len + 1];
			System.arraycopy(digits, 0, result, 1, len);
			result[0] = c;
			return result;
		}
	}
	
	public static void main(String[] args) {
		int[] digits = {9};
		int[] a = plusOne(digits);
		for(int i = 0; i < a.length; ++i){
			System.out.print(a[i]+" ");
		}
	}

}
