package leetcode;

public class InterleavingString {

	public static boolean isInterleave(String s1, String s2, String s3){
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if(len3 != len1 + len2) return false;
		int[][] f = new int[len2 + 1][len1 + 1];
		int p = 1;
		while(p <= len1 && s3.charAt(p - 1) == s1.charAt(p - 1)){
			f[0][p] = p;
			p++;
		}
		while(p <= len1) f[0][p++] = 9999;
		p = 1;
		while(p <= len2 && s3.charAt(p - 1) == s2.charAt(p - 1)){
			f[p][0] = p;
			p++;
		}
		while(p <= len2) f[p++][0] = 9999;
		for(int i = 1; i <= len2; ++i){
			for(int j = 1; j <= len1; ++j){
				if(s3.charAt(i + j - 1) == s1.charAt(j - 1)){
					if(f[i][j - 1] == i + j -1)
						f[i][j] = i + j;
				}
				if(s3.charAt(i + j - 1) == s2.charAt(i - 1)){
					if(f[i - 1][j] == i + j -1)
						f[i][j] = i + j;
				}
			}
		}
		return f[len2][len1] == len3;
	}
	public static boolean isInterleave2(String s1, String s2, String s3){
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if(len3 > len1 + len2) return false;
		int[][] f = new int[len1][len2];
		for(int i = 0; i < len1; ++i){
			for(int j = 0; j < len2; ++j){
				if(s3.charAt(i + j) == s1.charAt(i) || s3.charAt(i + j) == s2.charAt(j)){
					if(i == 0 && j != 0)
						f[i][j] = f[i][j - 1] + 1;
					else if(i != 0 && j == 0)
						f[i][j] = f[i - 1][j] + 1;
					else if(i != 0 && j != 0)
						f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
					else if(i == 0 && j == 0)
						f[i][j] = 1;
				} else
					f[i][j] = 9999;
			}
		}
		return f[len1 - 1][len2 - 1] == len3;
	}
	
	public static boolean dfs(String s1, String s2, String s3){
		if(s3.length() == 0) return true;
		if(s1.length() > 0 && s1.charAt(0) == s3.charAt(0))
			if(dfs(s1.substring(1), s2, s3.substring(1))) return true;
		if(s2.length() > 0 && s2.charAt(0) == s3.charAt(0))
			if(dfs(s1, s2.substring(1), s3.substring(1))) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isInterleave("a", "", "a"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

}
