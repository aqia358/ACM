package test.eight;

public class Main {

	private int count = 0;
	public void print(int[][] a){
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		count++;
		System.out.println("--------"+count+"--------");
	}
	public void write(int[][] a, int row, int col) {
		int i = 0;
		int j = 0;
		while (j < 7) {
			if (check2(a, row, j) && row < 7) {
				a[row][j] = 1;
				write(a, row+1, j);
				a[row][j] = 0;
			} else {
				a[row][j++] = 0;
			}
			print(a);
			j++;
		}
	}
	public void writeRow(int[][]a, int row, int col){
		for(int i = col; i < 8; i++){
			if(row == 8){
				print(a);
				return;
			}
			if(check2(a,row,i)){
				a[row][i] = 1;
				writeRow(a,++row,0);
				a[row-1][i] = 0;
			}else{
				a[row][i] = 0;
				writeRow(a,row,++i);
			}
		}
	}

	public boolean check2(int[][] a, int row, int col) {
		int i = 0;
		int j = 0;
		boolean flag = true;
		while (i < row) {
			if (a[i++][col] == 1) {
				flag = false;
				break;
			}
		}
		while (j < col) {
			if (a[row][j++] == 1) {
				flag = false;
				break;
			}
		}
		while (row >= 0 && col >= 0) {
			if (a[row--][col--] == 1) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Main m = new Main();
		int a[][] = new int[8][8];
		m.writeRow(a, 0, 0);
	}

}
