package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuSolver {

	public static void solveSudoku(char[][] board) {
		solve(board);
	}
	public static boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char n = '1'; n <= '9'; n++){
						board[i][j] = n;
						if (isValid(board, i, j) && solve(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isValid(char[][] board, int r, int c){
		int i,j;
		for(i = 0; i < 9; i++)
			if(i != r && board[i][c] == board[r][c])
				return false;
		for(j = 0; j < 9; j++)
			if(j != c && board[r][j] == board[r][c])
				return false;
		for(i = r/3*3; i < 3 * (r/3 + 1); i++)
			for(j = c/3*3; j < 3 * (c/3 + 1); j++)
				if((i != r || j!= c) && board[i][j] == board[r][c])
					return false;
		
		return true;
	}
	public static void solveSudoku2(char[][] board) {
		Map<Integer, List<Character>> b = new HashMap<Integer, List<Character>>();
		for (int i = 0; i < 27; i++)
			b.put(i, new ArrayList<Character>());
		solve(0, 0, board, b);
	}

	public static boolean solve(int r, int c, char[][] board, Map<Integer, List<Character>> b) {
		for (int i = r; i < 9; i++) {
			for (int j = c; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char n = '1'; n <= '9'; n++){
						add(n, i, j, board, b);
						if (valid(n, i, j, b) && solve(i, j, board, b)) {
							return true;
						}
						remove(n, i, j, board, b);
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void fill(int r, int c, char[][] board,
			Map<Integer, List<Character>> b) {
		if (c >= 9)
			return;
		for (int i = c; i < 9; i++) {
			if (board[r][i] == '.') {
				for (char n = '1'; n <= '9'; n++)
					if (valid(n, r, c, b)) {
						add(n, r, c, board, b);
						fill(r, c + 1, board, b);
						remove(n, r, c, board, b);
					}
			}
		}
		fill(r + 1, c, board, b);
	}

	public static void add(char n, int i, int j, char[][] board,
			Map<Integer, List<Character>> b) {
		board[i][j] = n;
		b.get(i).add(n);
		b.get(9 + j).add(n);
		b.get(18 + i / 3 * 3 + j / 3).add(n);
	}

	public static void remove(Character n, int i, int j, char[][] board,
			Map<Integer, List<Character>> b) {
		board[i][j] = '.';
		b.get(i).remove(n);
		b.get(9 + j).remove(n);
		b.get(18 + i / 3 * 3 + j / 3).remove(n);
	}

	public static boolean valid(char n, int i, int j,
			Map<Integer, List<Character>> b) {
		if (b.get(i).contains(n))
			return false;
		if (b.get(9 + j).contains(n))
			return false;
		if (b.get(18 + i / 3 * 3 + j / 3).contains(n))
			return false;
		return true;
	}

	public static void main(String[] args) {
		String[] a = { "..9748...", "7........", ".2.1.9...", "..7...24.",
				".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.." };
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = a[i].charAt(j);
			}
		}
		solveSudoku(board);
		System.out.print(5 / 3 * 3);
	}

}
