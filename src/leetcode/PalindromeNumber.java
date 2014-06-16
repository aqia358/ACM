package leetcode;

public class PalindromeNumber {

	public static boolean isPalindrome(int x){
		if(x < 0) return false;
		int n = 1;
		long temp = x;
		while((temp/=10) != 0){
			n++;
		}
		temp = x;
		for(int i = n - 1; i >= 0; i = i - 2){
			int h = (int) (temp/Math.pow(10, i));
			int l = (int) (temp%10);
			if(h == l){
				temp = (long) ((temp%Math.pow(10, i))/10);
			}else
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(10000021));
	}

}
