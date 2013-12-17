package oj.q1391q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public int top = 0;
	public int bottom;
	public int left = 0;
	public int right;
	public int[][] a;
	public int length;
	private int count = 0;

	public Main(int bottom, int right, int[][] a) {
		this.bottom = bottom;
		this.right = right;
		this.a = a;
		this.length = (bottom + 1) * (right + 1);
		if(length == 1)
			System.out.println(a[0][0]);
	}

	public void print() {
		if (left >= right && top <= bottom)
			return;
		for (int i = left; i <= right; i++) {
			p(a[top][i]);
		}
		if (top != bottom)
			top++;
		for (int j = top; j <= bottom; j++) {
			p(a[j][right]);
		}
		if (left != right)
			right--;
		for (int m = right; m >= left; m--) {
			p(a[bottom][m]);
		}
		if (top != bottom)
			bottom--;
		for (int n = bottom; n >= top; n--) {
			p(a[n][left]);
		}
		if (left != right)
			left++;
		print();
	}
	public void p(int value){
		if(count < length - 1){
			System.out.print(value+" ");
		}else if(count == length - 1){
			System.out.println(value);
		}
		count++;
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int row = (int)st.nval;
			st.nextToken();
			int col = (int)st.nval;
			int[][] a = new int[row][col];
			for(int i = 0; i < row; i++	){
				for(int j = 0; j < col; j++){
					st.nextToken();
					a[i][j] = (int)st.nval;
				}
			}
			Main m = new Main(row - 1, col - 1, a);
			m.print();
		}
	}

}
