package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens1 {

	public static int count;
	public static List<String[]> solveNQueens(int n) {
		List<String[]> re = new ArrayList<String[]>();
		placeQueens(new int[n], 0, re);
		return re;
	}
	
	public static void placeQueens(int[] q, int n, List<String[]> re){
		if(n == q.length){
			re.add(conver(q));
			return;
		}
		for(int i = 0; i < q.length; i++){
			if(isSafe(q, n , i)){
				q[n] = i;
				placeQueens(q, n + 1, re);
			}
		}
	}
	
	public static boolean isSafe(int[] q, int p, int value){
		for(int i = 0; i < p; i++){
			if(q[i] - i == value - p)
				return false;
			if(q[i] + i == value + p)
				return false;
			if(q[i] == value)
				return false;
		}
		return true;
	}
	
	public static String[] conver(int[] a){
		int len = a.length;
		String[] result = new String[len];
		for(int i = 0; i < a.length; i++){
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < a.length; j++){
				if(j == a[i])
					sb.append("Q");
				else
					sb.append(".");
			}
			result[i] = sb.toString();
		}
		return result;
	}
	
	public static void main(String[] args) {
		solveNQueens(8);
		System.out.println(count);
	}

}
