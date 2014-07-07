package leetcode;

public class EditDistance {

	private int min = Integer.MAX_VALUE;
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] f = new int[len1 + 1][len2 + 1];
		for(int i = 0; i <= len1; i++) f[i][0] = i;
		for(int j = 0; j <= len2; j++) f[0][j] = j;
		for(int i = 1; i <= len1; i++){
			for(int j = 1; j <= len2; j++){
				if(word1.charAt(i - 1) == word2.charAt(j - 1)){
					f[i][j] = f[i - 1][j - 1];
				}else{
					int temp = Math.min(f[i - 1][j], f[i][j - 1]);
					f[i][j] = Math.min(f[i - 1][j - 1], temp) + 1;
				}
			}
		}
		return f[len1][len2];
	}
	public int minDistance2(String word1, String word2) {
		dfs(word1, word2, 0);
		return min;
	}

	public void dfs(String word1, String word2, int step) {
		int len1 = word1.length();
		int len2 = word2.length();
		if (len1 > len2){
			dfs(word1.substring(1), word2, step + 1);//delete
			return;
		}
		if (len1 == 0 && len2 == 0){
			min = Math.min(min, step);
			return;
		}
		if (len1 > 0) {
			if (word1.charAt(0) == word2.charAt(0))
				dfs(word1.substring(1), word2.substring(1), step);
			else{
				dfs(word1.substring(1), word2.substring(1), step + 1);//replace
				dfs(word1.substring(1), word2, step + 1);//delete
			}
		} else {
			dfs(word1, word2.substring(1), step + 1);//add
		}
	}

	public static void main(String[] args) {
		EditDistance e = new EditDistance();
		System.out.println(e.minDistance2("dinitrophenylhydrazine", "acetylphenylhydrazine"));
	}

}
