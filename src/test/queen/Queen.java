package test.queen;

public class Queen {
	private int count = 0;

	public boolean isSafe(int col, int row, int[] queen) {
		for(int i = 0; i < row; i++){
			if (queen[i] == col){
				return false;
			}
			if (i == row){
				return false;
			}
			if (col + row == queen[i] + i){
				return false;
			}
			if (col - row == queen[i] - i){
				return false;
			}
		}
		return true;
	}

	public boolean placeQueen(int[] queen, int tempRow) {
		boolean flag = false;
		int tempCol = 0;
		if (tempRow == 8) {
//			flag = true;
			count++;
			System.out.println("------------"+count+"----");
			print(queen);
		} else {
			while (tempCol < 8 && !flag){
				if (isSafe(tempCol, tempRow, queen)) {
					queen[tempRow] = tempCol;
					flag = placeQueen(queen, tempRow+1);
					if(!flag){
						tempCol++;
					}
				} else {
					tempCol++;
				}
			}
		}
		return flag;
	}
	public void print(int[] queen){
		for(int i = 0; i < queen.length; i++){
			for(int j = 0; j < queen.length; j++){
				if(queen[i] != j){
					System.out.print("* ");
				}else{ 
					System.out.print("Q ");
				}
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		int[] a = new int[8];
		Queen q = new Queen();
		q.placeQueen(a, 0);
//		q.print(a);
	}

}
