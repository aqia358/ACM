package leetcode;

import java.util.ArrayList;
import java.util.List;

public class VaildSudoKu {

	public static boolean isValidSudoku(char[][] board){
		List<List<Character>> list = new ArrayList<List<Character>>();
		for(int i = 0; i < 18; i++){
			List<Character> l = new ArrayList<Character>();
			list.add(l);
		}
		for(int i = 0; i < 9; i++){
			List<Character> row = list.get(i);
			for(int j = 0; j < 9; j++){
				if(board[i][j] != '.'){
					List<Character> col = list.get(9 + j);
					if(row.contains(board[i][j]))
						return false;
					row.add(board[i][j]);
					if(col.contains(board[i][j]))
						return false;
					col.add(board[i][j]);
				}
			}
		}
		int row = 0;
		int col = 0;
		while(row < 9){
			while(col < 9){
				List<Character> l = new ArrayList<Character>();
				for(int i = row; i < row + 3; i++){
					for(int j = col; j < col + 3; j++){
						if(board[i][j] != '.'){
							if(l.contains(board[i][j]))
								return false;
							l.add(board[i][j]);
						}
					}
				}
				col += 3;
			}
			col = 0;
			row += 3;
		}
		return true;
	}
	public static void main(String[] args) {
		String[] a = {
				"....5..1.",
				".4.3.....",
				".....3..1",
				"8......2.",
				"..2.7....",
				".15......",
				".....2...",
				".2.9.....",
				"..4......"};
		char[][] board = new char[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = a[i].charAt(j);
			}
		}
		System.out.println(isValidSudoku(board));
	}
//	[[., ., ., ., 5, ., ., 1, .], 
//	 [., 4, ., 3, ., ., ., ., .], 
//	 [., ., ., ., ., 3, ., ., 1], 
//	 [8, ., ., ., ., ., ., 2, .], 
//	 [., ., 2, ., 7, ., ., ., .], 
//	 [., 1, 5, ., ., ., ., ., .], 
//	 [., ., ., ., ., 2, ., ., .], 
//	 [., 2, ., 9, ., ., ., ., .], 
//	 [., ., 4, ., ., ., ., ., .]]
}
