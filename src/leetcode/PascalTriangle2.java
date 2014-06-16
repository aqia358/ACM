package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author aqia358
 *
 */
public class PascalTriangle2 {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
		for(int i = 0; i <= rowIndex; ++i){
			for(int j = i - 1; j > 0; --j){
				result.set(j, result.get(j) + result.get(j - 1));
			}
			result.add(1);
		}
		return result;
	}
	public static List<Integer> getRow2(int rowIndex) {
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> q = new ArrayList<Integer>();
		p.add(1);
		return getRow(p, q, rowIndex);
	}
	
	public static List<Integer> getRow(List<Integer> p, List<Integer> q, int level){
		if(level == 0) return p;
		int len = p.size();
		q.add(1);
		for(int i = 1; i < len; ++i){
			q.add(i, p.get(i)+p.get(i-1));
		}
		q.add(1);
		p.clear();
		return getRow(q, p, level - 1);
	}
	
	public static void main(String[] args) {
		List<Integer> l = getRow(3);
		System.out.println();
	}

}
