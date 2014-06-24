package leetcode;

public class ValidPalindrome {

	public static boolean isPalindrome(String s){
		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		while(left < right){
			while(left < right && !vaild(s.charAt(left))){
				left++;
			}
			while(left < right && !vaild(s.charAt(right))){
				right--;
			}
			if(s.charAt(left) == s.charAt(right)){
				left++;
				right--;
			}else
				return false;
		}
		return true;
	}
	
	public static boolean vaild(char c){
		if(c >= 'a' && c <= 'z')
			return true;
		if(c >= '0' && c <= '9')
			return true;
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

}
