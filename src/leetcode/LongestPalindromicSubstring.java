package leetcode;

public class LongestPalindromicSubstring {

	public static char[] buildChar(String s) {
		char[] re = new char[2*s.length() + 1];
		int j = 1;
		re[0] = '*';
		for(int i = 0; i < s.length(); i++){
			re[j++] = s.charAt(i);
			re[j++] = '#';
		}
		re[re.length - 1] = '$';
		return re;
	}
	
	public static String manacher(String s) {
		char[] str = buildChar(s);
		int len = str.length;
		int[] f = new int[len];
		int max = 1;
		int p = 0;
		for(int i = 1,j = 0,k; i < len;){
			while(i - j - 1 >= 0 && i + j + 1 < len && str[i - j - 1] == str[i + j + 1])  //扫描得出f值
				++j;
			f[i] = j;
			p = max > j ? p : i;
			max = Math.max(j, max);
			for(k = 1; k <= j && f[i-k] != f[i] - k; k++) //k指针扫描
				f[i + k] = Math.min(f[i] - k, f[i - k]);
			i += k;//i跳到下一个需要计算f值的位置
			j = Math.max(j - k, 0);//更新下一个f值的初始值
		}
		int beginIndex = (p - max - 1)/2;
		int endIndex = beginIndex + max + 1;
		return s.substring(beginIndex < 0 ? 0 : beginIndex, endIndex > len ? len : endIndex);
	}
	
	public static String longestPalindromeDP(String s) {
		int len = s.length();
		int max = 1;
		int start = 0;
		boolean[][] f = new boolean[len][len];
//		for(int i = 0; i < len; ++i)
//			f[i][i] = true;
//		for(int i = 1; i < len; ++i){
//			if(s.charAt(i) == s.charAt(i - 1))
//				f[i][i - 1] = true;
//		}
		for(int i = 0; i < len; ++i){
			f[i][i] = true;
			for(int j = 0; j < i; j++){
				f[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || f[j + 1][i - 1]));
				if(f[j][i] && max < (i - j + 1)){
					max = i - j + 1;
					start = j;
				}
			}
		}
		return s.substring(start, start + max);
	}
	
	public static String longestPalindrome(String s) {
		int len = s.length();
		int max = 0;
		String maxs = "";
		for(int i = 0; i < len; i++){
			for(int j = i + max; j <= len; j++){
				if(isPalindrome(s.substring(i, j))){
					maxs = s.substring(i, j);
					max = j - i;
				}
			}
		}
		return maxs;
	}
	
	public static boolean isPalindrome(String str){
		int s = 0;
		int e = str.length() - 1;
		while(s <= e){
			if(str.charAt(s++) != str.charAt(e--))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(manacher("a"));
		System.out.println(manacher("aa"));
		System.out.println(manacher("aaa"));
		System.out.println(manacher("abaaba"));
	}

}
