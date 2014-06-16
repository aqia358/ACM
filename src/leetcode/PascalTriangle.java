package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author aqia358
 *
 */
public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		if(numRows == 0){
			result.add(row1);
			return result;
		}
		row1.add(1);
		result.add(row1);
		for(int i = 1; i < numRows; ++i){
			result.add(generate(result.get(i - 1), i));
		}
		return result;
	}
	
	public static List<Integer> generate(List<Integer> list, int numRows){
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for(int i = 1; i <= numRows - 1; ++i){
			row.add(list.get(i - 1)+list.get(i));
		}
		row.add(1);
		return row;
	}
	
	public static void main(String[] args) {
		generate(5);
	}

}
