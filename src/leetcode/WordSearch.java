package leetcode;

public class WordSearch {

	public static boolean exist(char[][] board, String word){
		if(word.length() == 0) return true;
		int row = board.length;
		if(row == 0) return false;
		int col = board[0].length;
		int[][] f = new int[row][col];
		for(int i = 0; i < row; ++i)
			for(int j = 0; j < col; ++j){
				if(board[i][j] == word.charAt(0)){
					for(int m = 0; m < row; m++)
						for(int n = 0; n < col; n++)
							f[m][n] = -1;
					if(dfs(board, i, j, word, 0, f)) return true;
				}
			}
		
		return false;
	}	
	
	public static boolean dfs(char[][] board, int row, int col, String word, int p, int[][] f){
		if(p == word.length()) return true;
		if(row < 0 || row >= board.length) return false;
		if(col < 0 || col >= board[0].length) return false;
		if(f[row][col] != -1) return false;
		if(board[row][col] == word.charAt(p)){
			f[row][col] = p;
			if( dfs(board, row + 1, col, word, p + 1, f) ||
					dfs(board, row, col + 1, word, p + 1, f) ||
					dfs(board, row - 1, col, word, p + 1, f) ||
					dfs(board, row, col - 1, word, p + 1, f)){
				return true;
			}
			f[row][col] = -1;
			return false;
		}else
			return false;
	}
	public static void main(String[] args) {
		char[][] b = {{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'},
				};
		System.out.println(exist(b, "ABCESEEEFS"));
		System.out.println(exist(b, "SEE"));
		System.out.println(exist(b, "ABCB"));
	}

}
