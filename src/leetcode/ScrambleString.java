package leetcode;

import java.util.Arrays;

public class ScrambleString {

	public static boolean isScramble(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 != len2) return false;
		if(len1 == 0) return true;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i = 0; i < len1; i++)
			if(c1[i] != c2[i]) return false;
		boolean result = false;
		for(int i = 1; i < len1 && !result; ++i){
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			result = isScramble(s11, s21) && isScramble(s12, s22);
			if(!result){
				String s31 = s2.substring(len1 -i);
				String s32 = s2.substring(0, len1 - i);
				result = isScramble(s11, s31) && isScramble(s12, s32);
			}
		}
		return result;
	}
	
	public static void dfs(String s1, String s2, int s, int e) {
		if(s == e) return ;
		for(int i = s; i <= e; i++){
			dfs(s1, s2, s, i);
			dfs(s1, s2, i + 1, e);
		}
	}
	
	public static void main(String[] args) {

	}

}
