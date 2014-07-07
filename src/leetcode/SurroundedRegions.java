package leetcode;

import java.util.LinkedList;

public class SurroundedRegions {

	public static void solve(char[][] board) {
		int row = board.length;
		if(row == 0) return ;
		int col = board[0].length;
		if(col == 0) return;
		for(int i = 0; i < row; i++){
			fill(board, i, 0);
			fill(board, i, col - 1);
		}
		for(int j = 0; j < col; j++){
			fill(board, 0, j);
			fill(board, row - 1, j);
		}
		for(int i = 0; i < row; ++i){
			for(int j = 0; j < col; ++j){
				if(board[i][j] == '#')
					board[i][j] = 'O';
				else if(board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}
	
	public static void fill(char[][] board, int i, int j){
		if(board[i][j] != 'O'){
			return ;
		}
		board[i][j] = '#';
		int row = board.length;
		int col = board[0].length;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(i*col+j);
		while(!q.isEmpty()){
			int p = q.pop();
			i = p/col;
			j = p%col;
			if(i > 0 && board[i - 1][j] == 'O'){
				q.offer((i - 1)*col + j);
				board[i - 1][j] = '#';
			}
			if(i < row - 1 && board[i + 1][j] == 'O'){
				q.offer((i + 1)*col + j);
				board[i + 1][j] = '#';
			}
			if(j > 0 && board[i][j - 1] == 'O'){
				q.offer(i*col + j - 1);
				board[i][j - 1] = '#';
			}
			if(j < col - 1 && board[i][j + 1] == 'O'){
				q.offer(i*col + j + 1);
				board[i][j + 1] = '#';
			}
		}
	}
	
	public static void main(String[] args) {
		char[][] board = {
					{'X','X','X','X'},
					{'X','O','O','X'},
					{'X','X','O','X'},
					{'X','O','X','X'},
					};
		solve(board);
		System.out.println();
	}

}
