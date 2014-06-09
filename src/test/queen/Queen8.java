package test.queen;

import java.util.HashMap;
import java.util.Map;

/**
 * 2014年5月30日 15:25:35
 * @author aqia358
 *
 */
public class Queen8 {
	
	private static Map<Integer, Integer> cols = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> left = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> right = new HashMap<Integer, Integer>();
	public static boolean place(int col, int row, int[][] q){
		if(row == 8){
			print(q);
			return true;
		}
		if(left.get(col - row) != null || right.get(col + row) != null || cols.get(col) != null) return false;
		left.put(col - row, 1);
		right.put(col + row, 1);
		cols.put(col, 1);
		q[col][row] = 1;
		for(int i = 0; i < 8; ++i){
			place(i, row + 1, q);
		}
		left.remove(col - row);
		right.remove(col + row);
		cols.remove(col);
		return false;
	}
	
	public static void print(int[][] a){
		for(int i =0; i < a.length; ++i){
			for(int j = 0; j < a.length; ++j)
				System.out.print(a[j][i]+" ");
			System.out.println();
		}
	}
	
	public static void start(){
		int[][] q = new int[8][8];
		for(int i = 0; i < 8; ++i){	
			place(i, 0, q);
		}
	}
	
	public static void main(String[] args) {
		start();
	}

}
