package leetcode;

public class DistinctSubsequences {

	private static int sum;
	
	public static int numDistinct(String S, String T) {
		int sLen = S.length();
		int tLen = T.length();
		int[] f = new int[tLen + 1];
		
		
		return 0;
	}
	public static int numDistinct1(String S, String T) {
		int sLen = S.length();
		int tLen = T.length();
		int[][] f = new int[sLen + 1][tLen + 1];
		f[0][0] = 1;
		for(int i = 1; i <= sLen; i++){
			for(int j = 1; j <= tLen; j++){
				f[i][j] = f[i - 1][j];
				if(S.charAt(i - 1) == T.charAt(j - 1))
					if(j == 1)
						f[i][j] += 1;
					else
						f[i][j] += f[i - 1][j - 1];
			}
		}
		return f[sLen][tLen];
	}
	public static int numDistinct2(String S, String T) {
		dfs(S, T);
		return sum;
	}
	
	public static void dfs(String S, String T) {
		if(T.length() == 0) sum++;
		if(S.length() > 0 && T.length() > 0 && S.charAt(0) == T.charAt(0)) dfs(S.substring(1), T.substring(1));
		if(S.length() > 0)
			dfs(S.substring(1), T);
	}
	public static int dfs(String S, String T, int sum) {
		if(T.length() == 0) return 1;
		if(S.length() > 0 && T.length() > 0 && S.charAt(0) == T.charAt(0)) sum += dfs(S.substring(1), T.substring(1), sum);
		if(S.length() > 0)
			sum += dfs(S.substring(1), T, sum);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(numDistinct1("ccc", "c"));
	}

}
